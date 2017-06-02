package com.sullivan.blog.function.admin.link.service;

import com.sullivan.blog.function.admin.link.Link;

import java.util.List;
import java.util.Map;

/**
 * @Description ��������Service�ӿ�
 * @author Sullivan
 *
 */
public interface LinkService {

	// ��ȡ��������
	public List<Link> getLinkData();

	public List<Link> listLinkData(Map<String, Object> map);

	// ��ȡ�ܼ�¼��
	public Long getTotal(Map<String, Object> map);

	// �����������
	public Integer addLink(Link link);

	// ������������
	public Integer updateLink(Link link);

	// ɾ����������
	public Integer deleteLink(Integer id);
}
