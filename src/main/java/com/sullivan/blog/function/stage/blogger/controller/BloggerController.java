package com.sullivan.blog.function.stage.blogger.controller;


import com.sullivan.blog.arc.util.CryptographyUtil;
import com.sullivan.blog.function.stage.blogger.Blogger;
import com.sullivan.blog.function.stage.blogger.service.BloggerService;
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
 * @Description ����Controller�㣬ǰ̨���֣�����Ҫ��֤
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
		
		Subject subject = SecurityUtils.getSubject(); //��ȡ��ǰ��½������
		String newPassword = CryptographyUtil.md5(blogger.getPassword(), "javacoder");//������ʹ��md5����
		//���û���Ϣ��װ��token��
		UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUsername(), newPassword);
		try {
			subject.login(token); //�����MyRealm�е�doGetAuthenticationInfo�������������֤
			return "redirect:/admin/main.jsp";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			request.setAttribute("bloger", blogger);
			request.setAttribute("errorInfo", "�û������������");
			return "login";
		} 

	}
	
	@RequestMapping("/aboutme")
	public ModelAndView abouotMe() {
		ModelAndView modelAndView = new ModelAndView();
		Blogger blogger = bloggerService.getBloggerData();
		modelAndView.addObject("blogger", blogger);
		modelAndView.addObject("commonPage", "foreground/blogger/bloggerInfo.jsp");
		modelAndView.addObject("title", "���ڲ��� - ������Ĳ���");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
	
	@RequestMapping("/myalbum")
	public ModelAndView myAlbum() {
		ModelAndView modelAndView = new ModelAndView();
		//Ҫдһ������service��ȡ���
		//Ҫ��һ������
		//....
		modelAndView.addObject("commonPage", "foreground/blogger/myAlbum.jsp");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
	
	@RequestMapping("/resource")
	public ModelAndView resource() {
		ModelAndView modelAndView = new ModelAndView();
		//
		//....
		modelAndView.addObject("commonPage", "foreground/blogger/resource.jsp");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
}
