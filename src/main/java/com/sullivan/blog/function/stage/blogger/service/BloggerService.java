package com.sullivan.blog.function.stage.blogger.service;

import com.sullivan.blog.function.stage.blogger.Blogger;

/**
 * @Description ����Service�ӿ�
 * @author Sullivan
 *
 */
public interface BloggerService {

	public Blogger getByUsername(String username);

	public Blogger getBloggerData();

	// ���²���������Ϣ
	public Integer updateBlogger(Blogger blogger);
}
