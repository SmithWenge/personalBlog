package com.sullivan.blog.function.stage.blog.controller;

import com.sullivan.blog.arc.util.PageUtil;
import com.sullivan.blog.arc.util.StringUtil;
import com.sullivan.blog.function.stage.blog.Blog;
import com.sullivan.blog.function.stage.blog.service.BlogService;
import com.sullivan.blog.function.stage.comment.Comment;
import com.sullivan.blog.function.stage.comment.service.CommentService;
import com.sullivan.blog.function.support.lucene.BlogIndex;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description ����Controller��
 * @author Sullivan
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

	@Resource
	private BlogService blogService;
	@Resource
	private CommentService commentService;

	private BlogIndex blogIndex = new BlogIndex();

	// ���󲩿���ϸ��Ϣ
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id") Integer id,
			HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		Blog blog = blogService.findById(id); // ����id��ȡ����

		// ��ȡ�ؼ���
		String keyWords = blog.getKeyWord();
		if (StringUtil.isNotEmpty(keyWords)) {
			String[] strArray = keyWords.split(" ");
			List<String> keyWordsList = StringUtil.filterWhite(Arrays
					.asList(strArray));
			modelAndView.addObject("keyWords", keyWordsList);
		} else {
			modelAndView.addObject("keyWords", null);
		}

		modelAndView.addObject("blog", blog);
		blog.setClickHit(blog.getClickHit() + 1); // �����ͷ�������1
		blogService.update(blog); // ���²���

		// ��ѯ������Ϣ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("blogId", blog.getId());
		map.put("state", 1);
		List<Comment> commentList = commentService.getCommentData(map);

		modelAndView.addObject("commentList", commentList);
		modelAndView.addObject("commonPage", "foreground/blog/blogDetail.jsp");
		modelAndView.addObject("title", blog.getTitle() + " - ������Ĳ���");

		// ������һƪ����һƪ����ʾ����
		modelAndView.addObject("pageCode", PageUtil.getPrevAndNextPageCode(
				blogService.getPrevBlog(id), blogService.getNextBlog(id),
				request.getServletContext().getContextPath()));

		modelAndView.setViewName("mainTemp");

		return modelAndView;
	}

	// ���ݹؼ��ֲ�ѯ������Ϣ
	@RequestMapping("/search")
	public ModelAndView search(
			@RequestParam(value = "q", required = false) String q,
			@RequestParam(value = "page", required = false) String page,
			HttpServletRequest request) throws Exception {

		int pageSize = 10;
		ModelAndView modelAndView = new ModelAndView();
		List<Blog> blogIndexList = blogIndex.searchBlog(q);
		if(page == null) { //pageΪ�ձ�ʾ��һ������
			page = "1";
		}
		int fromIndex = (Integer.parseInt(page) - 1) * pageSize; // ��ʼ����
		int toIndex = blogIndexList.size() >= Integer.parseInt(page) * pageSize ? Integer
				.parseInt(page) * pageSize
				: blogIndexList.size();
		modelAndView.addObject("blogIndexList", blogIndexList.subList(fromIndex, toIndex));
		modelAndView.addObject("pageCode", PageUtil.getUpAndDownPageCode(
				Integer.parseInt(page), blogIndexList.size(), q, pageSize,
				request.getServletContext().getContextPath()));
		modelAndView.addObject("q", q); // �������ݵĻ���
		modelAndView.addObject("resultTotal", blogIndexList.size()); // ��ѯ�����ܼ�¼��
		modelAndView.addObject("commonPage", "foreground/blog/searchResult.jsp");
		modelAndView.addObject("title", "����'" + q + "'�Ľ�� - ������Ĳ���");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}

}
