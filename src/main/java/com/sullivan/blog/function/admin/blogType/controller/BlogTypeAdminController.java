package com.sullivan.blog.function.admin.blogType.controller;

import com.sullivan.blog.arc.util.ResponseUtil;
import com.sullivan.blog.function.stage.blog.service.BlogService;
import com.sullivan.blog.function.stage.blogType.BlogType;
import com.sullivan.blog.function.stage.blogType.service.BlogTypeService;
import com.sullivan.blog.function.stage.index.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description ����Ա�������Controller��
 * @author Sullivan
 *
 */
@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {

	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private BlogService blogService;

	// ��ҳ��ѯ�������
	@RequestMapping("/listBlogType")
	public String listBlogType(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		List<BlogType> blogTypeList = blogTypeService.listBlogType(map);
		Long total = blogTypeService.getTotal(map);

		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(blogTypeList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	// ��Ӻ͸��²������
	@RequestMapping("/save")
	public String save(BlogType blogType, HttpServletResponse response)
			throws Exception {

		int resultTotal = 0; // ���շ��ؽ����¼��
		if (blogType.getId() == null) { // ˵���ǵ�һ�β���
			resultTotal = blogTypeService.addBlogType(blogType);
		} else { // ��id��ʾ�޸�
			resultTotal = blogTypeService.updateBlogType(blogType);
		}

		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}

	// ���������Ϣɾ��
	@RequestMapping("/delete")
	public String deleteBlog(
			@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws Exception {

		String[] idsStr = ids.split(",");
		JSONObject result = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			int id = Integer.parseInt(idsStr[i]);
			if(blogService.getBlogByTypeId(id) > 0) { //˵����������в���
				result.put("exist", "��������в��ͣ�����ɾ��!");
			} else {
				blogTypeService.deleteBlogType(id);
			}		
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
