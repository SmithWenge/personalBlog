package com.sullivan.blog.controller;


import com.sullivan.blog.entity.Blogger;
import com.sullivan.blog.service.BloggerService;
import com.sullivan.blog.util.CryptographyUtil;
import com.sullivan.blog.util.FTPUtil;
import com.sullivan.blog.util.FileUtil;
import com.sullivan.blog.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		modelAndView.addObject("title", "关于博主 - sullivan的博客");
		modelAndView.setViewName("/stage/index/mainTemp");
		return modelAndView;
	}

	@RequestMapping("/tools")
	public ModelAndView tools() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("commonPage", "stage/blogger/tools.jsp");
		modelAndView.addObject("title", "工具站 - sullivan的博客");
		modelAndView.setViewName("/stage/index/mainTemp");
		return modelAndView;
	}

	@RequestMapping("/resource/{dic}")
	public ModelAndView resource(@PathVariable("dic") String dic) throws UnsupportedEncodingException {
		// 转换编码格式，不然中文会出现乱码
		String keyword = new String(dic.getBytes("ISO-8859-1"), "utf-8");
		// 判断传过来的路径，如果为空的话证明是第一次打开，加上前缀。不为空的在后面附上值
		if (keyword == null || keyword.equals("")) {
			keyword = "/data/resources/";
		} else {
			keyword = "/data/resources/" + keyword.replace("_","/");
		}

		List<String> listLength = FileUtil.getLengths(keyword);
		List<String> listAbsolutePaths = FileUtil.getAbsolutePaths(keyword);
		List<Map<String,String>> maps = new ArrayList<>();
		for (int i = 0; i < listAbsolutePaths.size(); i++) {
			Map<String,String> map = new HashMap<>();

			// 转换前端传来路径的格式
			String cutedPath = listAbsolutePaths.get(i).replace("/data/resources/", "").replace("/","_");
			int start = listAbsolutePaths.get(i).lastIndexOf("/");
			// 获取文件名，因为不知道现在的路径是否是文件，所以用截字符串的方式实现
			String fileName = start == -1 ? "没有文件" : listAbsolutePaths.get(i).substring(start + 1);

			// 判断是否是文件（文件和文件夹的显示样式不同）
			File file = new File(listAbsolutePaths.get(i));
			if(file.isFile()) {
				map.put(cutedPath, fileName + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + listLength.get(i));
			} else {
				map.put(cutedPath, fileName);
			}

			maps.add(map);
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "资源站 - sullivan的博客");
		modelAndView.addObject("commonPage", "stage/blogger/resource.jsp");
		modelAndView.addObject("maps", maps);
		modelAndView.addObject("listAbsolutePaths", listAbsolutePaths);
		modelAndView.setViewName("/stage/index/mainTemp");
		return modelAndView;
	}

	@RequestMapping(value = "/download/{path}")
	public String download(@PathVariable("path") String path, HttpServletResponse response) throws UnsupportedEncodingException {
		// 转换编码格式，不然中文会出现乱码
		String keyword = new String(path.getBytes("ISO-8859-1"), "utf-8");
		File localFile = new File("/data/resources/" + keyword.replace("_","/"));

		if (localFile.isDirectory()) {
			return "redirect:/blogger/resource/"+localFile.getAbsolutePath().replace("/data/resources/","").replace("/","_")+".do";
		}

		try {
			response.setContentType("application/x-export");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(localFile.getName(), "UTF-8"));
			response.setHeader("Content-Length", String.valueOf(localFile.length()));
			int length = 0;
			byte[] buffer = new byte[1024];
			FileInputStream fis = new FileInputStream(localFile);
			OutputStream os = response.getOutputStream();
			while (-1 != (length = fis.read(buffer, 0, buffer.length))) {
				os.write(buffer, 0, length);
			}
			fis.close();
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
