package com.sullivan.blog.function.stage.blog.service;

import com.sullivan.blog.function.stage.blog.Blog;

import java.util.List;
import java.util.Map;

/**
 * @Description ����Service�ӿ�
 * @author Sullivan
 *
 */
public interface BlogService {

	public List<Blog> getBlogData();

	// ��ҳ��ѯ����
	public List<Blog> listBlog(Map<String, Object> map);

	// ��ȡ�ܼ�¼��
	public Long getTotal(Map<String, Object> map);

	// ����id��ȡ����
	public Blog findById(Integer id);

	// ���²�����Ϣ
	public Integer update(Blog blog);

	// ��ȡ��һƪ����
	public Blog getPrevBlog(Integer id);

	// ��ȡ��һƪһƪ����
	public Blog getNextBlog(Integer id);

	// ��Ӳ���
	public Integer addBlog(Blog blog);
	
	// ɾ��������Ϣ
	public Integer deleteBlog(Integer id);
	
	// ���ݲ������͵�id��ѯ�������µĲ�������
	public Integer getBlogByTypeId(Integer typeId);
}
