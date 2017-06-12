package com.sullivan.blog.controller;


import com.sullivan.blog.entity.Blogger;
import com.sullivan.blog.service.BloggerService;
import com.sullivan.blog.util.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description 博主Controller层，前台部分，不需要认证
 * @author Sullivan
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@Resource
	private BloggerService bloggerService;

	@RequestMapping("/login")
	public String login(Blogger blogger, HttpServletRequest request) {

		Subject subject = SecurityUtils.getSubject(); //获取当前登陆的主体
		String newPassword = CryptographyUtil.md5(blogger.getPassword(), "javacoder");//将密码使用md5加密
		//将用户信息封装到token中
		UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUsername(), newPassword);
		try {
			subject.login(token); //会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证
			return "redirect:/admin/routeMain.html";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			request.setAttribute("bloger", blogger);
			request.setAttribute("errorInfo", "用户名或密码错误");
			return "/admin/login";
		}

	}

	@RequestMapping("/aboutme")
	public ModelAndView abouotMe() {
		ModelAndView modelAndView = new ModelAndView();
		Blogger blogger = bloggerService.getBloggerData();
		modelAndView.addObject("blogger", blogger);
		modelAndView.addObject("commonPage", "stage/blogger/bloggerInfo.jsp");
		modelAndView.addObject("title", "关于博主 - 史汉文的博客");
		modelAndView.setViewName("/stage/index/mainTemp");
		return modelAndView;
	}

	@RequestMapping("/tools")
	public ModelAndView tools() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("commonPage", "stage/blogger/tools.jsp");
		modelAndView.addObject("title", "关于博主 - 史汉文的博客");
		modelAndView.setViewName("/stage/index/mainTemp");
		return modelAndView;
	}

	@RequestMapping("/resource")
	public ModelAndView resource() {
		ModelAndView modelAndView = new ModelAndView();
		//
		//....
		modelAndView.addObject("title", "关于博主 - 史汉文的博客");
		modelAndView.addObject("commonPage", "stage/blogger/resource.jsp");
		modelAndView.setViewName("/stage/index/mainTemp");
		return modelAndView;
	}
}
