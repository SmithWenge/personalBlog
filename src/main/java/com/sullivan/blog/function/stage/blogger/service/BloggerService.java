package com.sullivan.blog.function.stage.blogger.service;

import com.sullivan.blog.function.stage.blogger.Blogger;

/**
 * @Description 博主Service接口
 * @author Sullivan
 *
 */
public interface BloggerService {

	public Blogger getByUsername(String username);

	public Blogger getBloggerData();

	// 更新博主个人信息
	public Integer updateBlogger(Blogger blogger);
}
