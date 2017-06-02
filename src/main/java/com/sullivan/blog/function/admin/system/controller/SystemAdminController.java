package com.sullivan.blog.function.admin.system.controller;

import com.sullivan.blog.arc.util.ResponseUtil;
import com.sullivan.blog.function.admin.link.Link;
import com.sullivan.blog.function.admin.link.service.LinkService;
import com.sullivan.blog.function.stage.blog.Blog;
import com.sullivan.blog.function.stage.blog.service.BlogService;
import com.sullivan.blog.function.stage.blogType.BlogType;
import com.sullivan.blog.function.stage.blogType.service.BlogTypeService;
import com.sullivan.blog.function.stage.blogger.Blogger;
import com.sullivan.blog.function.stage.blogger.service.BloggerService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description 管理员系统controller层
 * @author Sullivan
 *
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {

	@Resource
	private BloggerService bloggerService;
	@Resource
	private LinkService linkService;
	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private BlogService blogService;

	// 刷新系统缓存
	@RequestMapping("/refreshSystemCache")
	public String refreshSystemCache(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ServletContext application = RequestContextUtils.getWebApplicationContext(request).getServletContext();
		
		// 获取博主信息
		Blogger blogger = bloggerService.getBloggerData();
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);

		// 获取友情链接信息
		List<Link> linkList = linkService.getLinkData();
		application.setAttribute("linkList", linkList);

		// 获取博客类别信息
		List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
		application.setAttribute("blogTypeList", blogTypeList);

		// 获取博客信息，按照时间分类的
		List<Blog> blogTimeList = blogService.getBlogData();
		application.setAttribute("blogTimeList", blogTimeList);
		
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
