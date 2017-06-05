package com.sullivan.blog.listener;

import com.sullivan.blog.entity.Blog;
import com.sullivan.blog.entity.BlogType;
import com.sullivan.blog.entity.Blogger;
import com.sullivan.blog.entity.Link;
import com.sullivan.blog.service.BlogService;
import com.sullivan.blog.service.BlogTypeService;
import com.sullivan.blog.service.BloggerService;
import com.sullivan.blog.service.LinkService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * @Description 初始化类
 * @author Sullivan
 */

@Component
public class InitBloggerData implements ServletContextListener, ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(applicationContext);
		//先获取servlet上下文
		ServletContext application = sce.getServletContext();

		//根据spring的上下文获取bloggerService这个bean
		BloggerService bloggerService = (BloggerService) applicationContext.getBean("bloggerService");
		//获取博主信息
		Blogger blogger = bloggerService.getBloggerData();
		//由于密码也获取到了，比较敏感，我们也不需要这个，所以把密码清空掉
		blogger.setPassword(null);
		//将博主信息存入application域中
		application.setAttribute("blogger", blogger);

		//同上，获取友情链接信息
		LinkService linkService = (LinkService) applicationContext.getBean("linkService");
		List<Link> linkList = linkService.getLinkData();
		application.setAttribute("linkList", linkList);

		//同上，获取博客类别信息
		BlogTypeService blogTypeService = (BlogTypeService) applicationContext.getBean("blogTypeService");
		List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
		application.setAttribute("blogTypeList", blogTypeList);

		//同上，获取博客信息，按照时间分类的
		BlogService blogService = (BlogService) applicationContext.getBean("blogService");
		List<Blog> blogTimeList = blogService.getBlogData();
		application.setAttribute("blogTimeList", blogTimeList);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		InitBloggerData.applicationContext = applicationContext;
	}

}
