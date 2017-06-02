package com.sullivan.blog.function.stage.blogger.service.impl;

import com.sullivan.blog.function.stage.blogger.Blogger;
import com.sullivan.blog.function.stage.blogger.dao.BloggerDao;
import com.sullivan.blog.function.stage.blogger.service.BloggerService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * @Description 博主Service实现类
 * @author Sullivan
 *
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
	
	@Resource
	private BloggerDao bloggerDao;
	
	//根据用户名查询博主信息，用于登陆
	public Blogger getByUsername(String username) {
		return bloggerDao.getByUsername(username);
	}

	//获取博主信息
	public Blogger getBloggerData() {
		return bloggerDao.getBloggerData();
	}

	public Integer updateBlogger(Blogger blogger) {
		return bloggerDao.updateBlogger(blogger);
	}

}
