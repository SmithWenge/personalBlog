package com.sullivan.blog.function.stage.blogger;


/**
 * @Description ����ʵ��
 * @author Sullivan
 *
 */
public class Blogger {
	
	private Integer id;
	private String username; //�˺�
	private String password; //����
	private String profile; //������Ϣ
	private String nickname; //�����ǳ�
	private String sign; //����ǩ��
	private String imagename; //ͷ��·��
	private String name; //����
	private String email; //����
	private String address; //סַ
	private String linkBlog; //���Ӳ���

	public String getLinkBlog() {
		return linkBlog;
	}
	public void setLinkBlog(String linkBlog) {
		this.linkBlog = linkBlog;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) { this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

}
