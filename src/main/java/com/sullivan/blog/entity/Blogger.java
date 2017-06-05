package com.sullivan.blog.entity;


/**
 * @Description 博主实体
 * @author Sullivan
 *
 */
public class Blogger {

	private Integer id;
	private String username; //账号
	private String password; //密码
	private String profile; //博主信息
	private String nickname; //博主昵称
	private String sign; //博主签名
	private String imagename; //头像路径
	private String name; //姓名
	private String email; //邮箱
	private String address; //住址
	private String linkBlog; //链接博客

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
