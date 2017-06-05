package com.sullivan.blog.service;

import com.sullivan.blog.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * @Description 博客Service接口
 * @author Sullivan
 *
 */
public interface BlogService {

	public List<Blog> getBlogData();

	// 分页查询博客
	public List<Blog> listBlog(Map<String, Object> map);

	// 获取总记录数
	public Long getTotal(Map<String, Object> map);

	// 根据id获取博客
	public Blog findById(Integer id);

	// 更新博客信息
	public Integer update(Blog blog);

	// 获取上一篇博客
	public Blog getPrevBlog(Integer id);

	// 获取下一篇一篇博客
	public Blog getNextBlog(Integer id);

	// 添加博客
	public Integer addBlog(Blog blog);

	// 删除博客信息
	public Integer deleteBlog(Integer id);

	// 根据博客类型的id查询该类型下的博客数量
	public Integer getBlogByTypeId(Integer typeId);
}
