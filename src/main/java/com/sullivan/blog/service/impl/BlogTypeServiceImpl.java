package com.sullivan.blog.service.impl;

import com.sullivan.blog.entity.BlogType;
import com.sullivan.blog.dao.BlogTypeDao;
import com.sullivan.blog.service.BlogTypeService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description 博客类别Service实现类
 * @author Sullivan
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

	@Resource
	private BlogTypeDao blogTypeDao;

	//获取博客类别信息
	public List<BlogType> getBlogTypeData() {
		return blogTypeDao.getBlogTypeData();
	}

	public List<BlogType> listBlogType(Map<String, Object> map) {
		return blogTypeDao.listBlogType(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return blogTypeDao.getTotal(map);
	}

	public Integer addBlogType(BlogType blogType) {
		return blogTypeDao.addBlogType(blogType);
	}

	public Integer updateBlogType(BlogType blogType) {
		return blogTypeDao.updateBlogType(blogType);
	}

	public Integer deleteBlogType(Integer id) {
		return blogTypeDao.deleteBlogType(id);
	}

}
