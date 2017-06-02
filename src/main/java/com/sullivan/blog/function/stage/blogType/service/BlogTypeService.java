package com.sullivan.blog.function.stage.blogType.service;

import com.sullivan.blog.function.stage.blogType.BlogType;

import java.util.List;
import java.util.Map;

/**
 * @Description �������Service�ӿ�
 * @author Sullivan
 *
 */
public interface BlogTypeService {

	public List<BlogType> getBlogTypeData();

	// ��ҳ��ѯ���������Ϣ
	public List<BlogType> listBlogType(Map<String, Object> map);

	// ��ȡ�ܼ�¼��
	public Long getTotal(Map<String, Object> map);
	
	// ��Ӳ������
	public Integer addBlogType(BlogType blogType);
	
	// ���²������
	public Integer updateBlogType(BlogType blogType);
	
	// ɾ���������
	public Integer deleteBlogType(Integer id);
}
