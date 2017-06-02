package com.sullivan.blog.function.stage.blogger.dao;


import com.sullivan.blog.function.stage.blogger.Blogger;

/**
 * @Description ����dao�ӿ�
 * @author Sullivan
 *
 */
public interface BloggerDao {

	//ͨ���û�����ѯ����
	public Blogger getByUsername(String username);

	//��ȡ������Ϣ
	public Blogger getBloggerData();

	// ���²���������Ϣ
	public Integer updateBlogger(Blogger blogger);
}
