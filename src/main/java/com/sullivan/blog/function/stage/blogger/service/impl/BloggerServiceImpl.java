package com.sullivan.blog.function.stage.blogger.service.impl;

import com.sullivan.blog.function.stage.blogger.Blogger;
import com.sullivan.blog.function.stage.blogger.dao.BloggerDao;
import com.sullivan.blog.function.stage.blogger.service.BloggerService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * @Description ����Serviceʵ����
 * @author Sullivan
 *
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
	
	@Resource
	private BloggerDao bloggerDao;
	
	//�����û�����ѯ������Ϣ�����ڵ�½
	public Blogger getByUsername(String username) {
		return bloggerDao.getByUsername(username);
	}

	//��ȡ������Ϣ
	public Blogger getBloggerData() {
		return bloggerDao.getBloggerData();
	}

	public Integer updateBlogger(Blogger blogger) {
		return bloggerDao.updateBlogger(blogger);
	}

}
