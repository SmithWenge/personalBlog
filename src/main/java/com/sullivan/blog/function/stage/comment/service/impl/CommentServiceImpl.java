package com.sullivan.blog.function.stage.comment.service.impl;

import com.sullivan.blog.function.stage.comment.Comment;
import com.sullivan.blog.function.stage.comment.dao.CommentDao;
import com.sullivan.blog.function.stage.comment.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description 用户评论service实现类
 * @author Sullivan
 *
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Resource
	private CommentDao commentDao;

	public List<Comment> getCommentData(Map<String, Object> map) {
		return commentDao.getCommentData(map);
	}

	public int addComment(Comment comment) {
		return commentDao.addComment(comment);
	}

	public Long getTotal(Map<String, Object> map) {
		return commentDao.getTotal(map);
	}

	public Integer update(Comment comment) {
		return commentDao.update(comment);
	}

	public Integer deleteComment(Integer id) {
		return commentDao.deleteComment(id);
	}

	public Integer deleteCommentByBlogId(Integer blogId) {
		return commentDao.deleteCommentByBlogId(blogId);
	}

}
