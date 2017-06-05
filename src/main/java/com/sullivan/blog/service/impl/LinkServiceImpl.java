package com.sullivan.blog.service.impl;

import com.sullivan.blog.dao.LinkDao;
import com.sullivan.blog.entity.Link;
import com.sullivan.blog.service.LinkService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description 友情链接Service实现类
 * @author Sullivan
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkDao linkDao;

	public List<Link> getLinkData() {
		return linkDao.getLinkData();
	}

	public List<Link> listLinkData(Map<String, Object> map) {
		return linkDao.listLinkData(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return linkDao.getTotal(map);
	}

	public Integer addLink(Link link) {
		return linkDao.addLink(link);
	}

	public Integer updateLink(Link link) {
		return linkDao.updateLink(link);
	}

	public Integer deleteLink(Integer id) {
		return linkDao.deleteLink(id);
	}

}
