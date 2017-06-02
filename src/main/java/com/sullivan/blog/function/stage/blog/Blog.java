package com.sullivan.blog.function.stage.blog;

import com.sullivan.blog.function.stage.blogType.BlogType;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description ����ʵ��
 * @author Sullivan
 *
 */
public class Blog {

	private Integer id;
	private String title;
	private String summary;
	private Date releaseDate;
	private Integer clickHit;
	private Integer replyHit;
	private String content;
	private String contentNoTag; //������ǩ�Ĳ������ݣ�����Lucene������
	private String keyWord; //�ؼ��֣��ÿո����
	
	private BlogType blogType; //��������
	private Integer blogCount; //�����������ǲ���ʵ�����ԣ����ڸ��ݷ������ڹ鵵��ѯ
	private String releaseDateStr; //�������ڵ��ַ�����ֻȡ����
	
	private List<String> imageList = new LinkedList<String>();//��������ͼƬ����Ҫ����չʾ����ͼ

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getClickHit() {
		return clickHit;
	}

	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}

	public Integer getReplyHit() {
		return replyHit;
	}

	public void setReplyHit(Integer replyHit) {
		this.replyHit = replyHit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public BlogType getBlogType() {
		return blogType;
	}

	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}

	public Integer getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}

	public String getReleaseDateStr() {
		return releaseDateStr;
	}

	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public String getContentNoTag() {
		return contentNoTag;
	}

	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
	}
	
}
