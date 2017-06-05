package com.sullivan.blog.dao;


import com.sullivan.blog.entity.Blogger;

/**
 * @Description 博主dao接口
 * @author Sullivan
 *
 */
public interface BloggerDao {

	//通过用户名查询博主
	public Blogger getByUsername(String username);

	//获取博主信息
	public Blogger getBloggerData();

	// 更新博主个人信息
	public Integer updateBlogger(Blogger blogger);
}
