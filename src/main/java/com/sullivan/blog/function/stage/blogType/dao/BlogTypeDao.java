package com.sullivan.blog.function.stage.blogType.dao;

import com.sullivan.blog.function.stage.blogType.BlogType;

import java.util.List;
import java.util.Map;

/**
 * @Description �������dao�ӿ�
 * @author Sullivan
 *
 */
public interface BlogTypeDao {

	// ��ȡ���������Ϣ
	public List<BlogType> getBlogTypeData();

	// ����id���Ҳ���������Ϣ
	public BlogType findById(Integer id);

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
