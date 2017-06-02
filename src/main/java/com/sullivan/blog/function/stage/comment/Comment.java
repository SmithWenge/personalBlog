package com.sullivan.blog.function.stage.comment;

import com.sullivan.blog.function.stage.blog.Blog;

import java.util.Date;

/**
 * @Description ����ʵ��
 * @author Sullivan
 *
 */
public class Comment {

	private Integer id;
	private String userIp; //�����û���ip
	private String content; //��������
	private Date commentDate; //��������
	private Integer state; //���״̬��0����� 1���ͨ�� 2δͨ��
	private Blog blog; //�����Ĳ���
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
