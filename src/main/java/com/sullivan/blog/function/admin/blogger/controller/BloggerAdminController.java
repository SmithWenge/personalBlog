package com.sullivan.blog.function.admin.blogger.controller;

import com.sullivan.blog.arc.util.CryptographyUtil;
import com.sullivan.blog.arc.util.DateUtil;
import com.sullivan.blog.arc.util.ResponseUtil;
import com.sullivan.blog.function.stage.blogger.Blogger;
import com.sullivan.blog.function.stage.blogger.service.BloggerService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @Description ����Ա����Controller�㣬��Ҫ�����֤
 * @author Sullivan
 *
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

	@Resource
	private BloggerService bloggerService;
	
	// ��ѯ������Ϣ
	@RequestMapping("/findBlogger")
	public String findBlogger(HttpServletResponse response) throws Exception {
		
		Blogger blogger = bloggerService.getBloggerData();
		JSONObject jsonObject = JSONObject.fromObject(blogger);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
	//�޸Ĳ�����Ϣ
	@RequestMapping("/save")
	public String save(
			@RequestParam("imageFile") MultipartFile imageFile,
			Blogger blogger,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!imageFile.isEmpty()) { //����û��д�����Ƭ���͸���
			String filePath = request.getServletContext().getRealPath("/"); //��ȡ��������·��
			String imageName = DateUtil.getCurrentDateStr() + "." + imageFile.getOriginalFilename().split("\\.")[1];
			imageFile.transferTo(new File(filePath + "static/userImages/" + imageName));
			blogger.setImagename(imageName);
		}
		int resultTotal = bloggerService.updateBlogger(blogger);
		JSONObject result = new JSONObject();
		if(resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	//�޸Ĳ�������
	@RequestMapping("/modifyPassword")
	public String modifyPassword(
			@RequestParam("password") String password,
			HttpServletResponse response) throws Exception {
		
		Blogger blogger = new Blogger();
		blogger.setPassword(CryptographyUtil.md5(password, "javacoder"));
		int resultTotal = bloggerService.updateBlogger(blogger);
		JSONObject result = new JSONObject();
		if(resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	// �˳�
	@RequestMapping("/logout")
	public String logout() throws Exception {
		
		SecurityUtils.getSubject().logout();
		return "redirect:/login.jsp";
	}
}
