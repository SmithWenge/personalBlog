package com.sullivan.blog.controller.admin;

import com.sullivan.blog.entity.Blog;
import com.sullivan.blog.util.DateJsonValueProcessor;
import com.sullivan.blog.util.ResponseUtil;
import com.sullivan.blog.util.StringUtil;
import com.sullivan.blog.service.BlogService;
import com.sullivan.blog.service.CommentService;
import com.sullivan.blog.entity.PageBean;
import com.sullivan.blog.lucene.BlogIndex;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 管理员博客Controller层
 * @author Sullivan
 *
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

	@Resource
	private BlogService blogService;
	@Resource
	private CommentService commentService;

	private BlogIndex blogIndex = new BlogIndex();

	//添加和更新博客
	@RequestMapping("/save")
	public String save(Blog blog, HttpServletResponse response) throws Exception {

		int resultTotal = 0; //接收返回结果记录数
		if(blog.getId() == null) { //说明是第一次插入
			resultTotal = blogService.addBlog(blog);
			blogIndex.addIndex(blog); //添加博客的索引
		} else { //有id表示修改
			resultTotal = blogService.update(blog);
			blogIndex.updateIndex(blog);
		}

		JSONObject result = new JSONObject();
		if(resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}

	//后台分页查询博客信息
	@RequestMapping("/listBlog")
	public String listBlog(
			@RequestParam(value="page", required=false)String page,
			@RequestParam(value="rows", required=false)String rows,
			Blog s_blog,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", StringUtil.formatLike(s_blog.getTitle())); //模糊查询
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		List<Blog> blogList = blogService.listBlog(map);
		Long total = blogService.getTotal(map);

		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(blogList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	// 博客信息删除
	@RequestMapping("/delete")
	public String deleteBlog(
			@RequestParam(value="ids", required=false)String ids,
			HttpServletResponse response) throws Exception {

		String[] idsStr = ids.split(",");
		for(int i = 0; i < idsStr.length; i++) {
			int id = Integer.parseInt(idsStr[i]);
			commentService.deleteCommentByBlogId(id);
			blogService.deleteBlog(id);
			blogIndex.deleteIndex(idsStr[i]);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	//通过id获取博客实体
	@RequestMapping("/findById")
	public String findById(
			@RequestParam(value="id", required=false)String id,
			HttpServletResponse response) throws Exception {

		Blog blog = blogService.findById(Integer.parseInt(id));
		JSONObject result = JSONObject.fromObject(blog);
		ResponseUtil.write(response, result);
		return null;
	}
}
