package com.sullivan.blog.function.stage.comment.controller;

import com.sullivan.blog.arc.util.ResponseUtil;
import com.sullivan.blog.function.stage.blog.Blog;
import com.sullivan.blog.function.stage.blog.service.BlogService;
import com.sullivan.blog.function.stage.comment.Comment;
import com.sullivan.blog.function.stage.comment.service.CommentService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description ���۵�controller
 * @author Sullivan
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Resource
	private CommentService commentService;
	@Resource
	private BlogService blogService;
	
	//��ӻ����޸�����
	@RequestMapping("/save")
	public String save(
			Comment comment,
			@RequestParam("imageCode")String imageCode, //ǰ̨��������֤��
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) throws Exception {
		
		String sRand = (String) session.getAttribute("sRand");//��ȡsession����ȷ����֤�룬��֤��������浽session�е�
		JSONObject result = new JSONObject();
		int resultTotal = 0; //ִ�м�¼��
		if(!imageCode.equals(sRand)) {
			result.put("success", false);
			result.put("errorInfo", "��֤������");
		} else {
			String userIp = request.getRemoteAddr(); //��ȡ�����û���ip
			comment.setUserIp(userIp);  //��userIp���ý�ȥ
			if(comment.getId() == null) { //û��id��ʾ���
				resultTotal = commentService.addComment(comment); //�������
				Blog blog = blogService.findById(comment.getBlog().getId()); //����һ�²��͵����۴���
				blog.setReplyHit(blog.getReplyHit() + 1);
				blogService.update(blog);
			} else { //��id��ʾ�޸�
				
			}
		}		
		//�ж��Ƿ���ӳɹ�
		if(resultTotal > 0) {
			result.put("success", true);
		}		
		ResponseUtil.write(response, result);
		return null;
	}
}
