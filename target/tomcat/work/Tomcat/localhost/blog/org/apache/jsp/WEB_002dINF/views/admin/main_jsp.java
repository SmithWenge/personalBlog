/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2017-06-05 05:11:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
      out.write("<html>\n");
      out.write("<head>    \n");
      out.write("<title>SSM个人博客系统后台管理页面</title>   \n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/jquery-easyui-1.3.3/themes/default/easyui.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/jquery-easyui-1.3.3/themes/icon.css\">\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/jquery-easyui-1.3.3/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/jquery-easyui-1.3.3/jquery.easyui.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("\tfunction openTab(text,url,iconCls){\n");
      out.write("\t\tif($(\"#tabs\").tabs(\"exists\",text)){\n");
      out.write("\t\t\t$(\"#tabs\").tabs(\"select\",text);\n");
      out.write("\t\t}else{\n");
      out.write("\t\t\tvar content=\"<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/\"+url+\"'></iframe>\";\n");
      out.write("\t\t\t$(\"#tabs\").tabs(\"add\",{\n");
      out.write("\t\t\t\ttitle:text,\n");
      out.write("\t\t\t\ticonCls:iconCls,\n");
      out.write("\t\t\t\tclosable:true,\n");
      out.write("\t\t\t\tcontent:content\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction openPasswordModifyDialog() {\n");
      out.write("\t\t$(\"#dlg\").dialog(\"open\").dialog(\"setTitle\", \"修改密码\");\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\tfunction modifyPassword() {\n");
      out.write("\t\t$(\"#fm\").form(\"submit\",{\n");
      out.write("\t\t\turl: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/blogger/modifyPassword.do\",\n");
      out.write("\t\t\tonSubmit: function() {\n");
      out.write("\t\t\t\tvar newPassword = $(\"#password\").val();\n");
      out.write("\t\t\t\tvar newPassword2 = $(\"#password2\").val();\n");
      out.write("\t\t\t\tif(!$(this).form(\"validate\")) {\n");
      out.write("\t\t\t\t\treturn false; //验证不通过直接false，即没填\n");
      out.write("\t\t\t\t} \n");
      out.write("\t\t\t\tif(newPassword != newPassword2) {\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统提示\", \"两次密码必须填写一致\");\n");
      out.write("\t\t\t\t\treturn false\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\treturn true;\n");
      out.write("\t\t\t}, //进行验证，通过才让提交\n");
      out.write("\t\t\tsuccess: function(result) {\n");
      out.write("\t\t\t\tvar result = eval(\"(\" + result + \")\"); //将json格式的result转换成js对象\n");
      out.write("\t\t\t\tif(result.success) {\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统提示\", \"密码修改成功，下一次登陆生效\");\n");
      out.write("\t\t\t\t\tclosePasswordModifyDialog();\n");
      out.write("\t\t\t\t} else {\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统提示\", \"密码修改失败\");\n");
      out.write("\t\t\t\t\treturn;\n");
      out.write("\t\t\t\t} \n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction closePasswordModifyDialog() {\n");
      out.write("\t\t$(\"#password\").val(\"\"); //保存成功后将内容置空\n");
      out.write("\t\t$(\"#password2\").val(\"\");\n");
      out.write("\t\t$(\"#dlg\").dialog(\"close\"); //关闭对话框\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\tfunction refreshSystemCache() {\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/system/refreshSystemCache.do\",{},function(result){\n");
      out.write("\t\t\tif(result.success){\n");
      out.write("\t\t\t\t$.messager.alert(\"系统提示\",\"已成功刷新系统缓存！\");\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\t$.messager.alert(\"系统提示\",\"刷新系统缓存失败！\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t},\"json\");\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction logout() {\n");
      out.write("\t\t$.messager.confirm(\"系统提示\",\"您确定要退出系统吗？\", function(r){\n");
      out.write("\t\t\tif(r) {\n");
      out.write("\t\t\t\twindow.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/blogger/logout.do\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\tbody {\n");
      out.write("\t\tfont-family: microsoft yahei;\n");
      out.write("\t}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("  \n");
      out.write("<body class=\"easyui-layout\">\n");
      out.write("<div region=\"north\" style=\"height: 78px; background-color: #E0ECFF\">\n");
      out.write("\t<table style=\"padding: 5px\" width=\"100%\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td width=\"50%\">\n");
      out.write("\t\t\t\t<h2>博客后台系统</h2>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t<td valign=\"bottom\" align=\"right\" width=\"50%\">\n");
      out.write("\t\t\t\t<font size=\"3\">&nbsp;&nbsp;<strong>欢迎：</strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</font>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</table>\n");
      out.write("</div>\n");
      out.write("<div region=\"center\">\n");
      out.write("\t<div class=\"easyui-tabs\" fit=\"true\" border=\"false\" id=\"tabs\">\n");
      out.write("\t\t<div title=\"首页\" data-options=\"iconCls:'icon-home'\">\n");
      out.write("\t\t\t<div align=\"center\" style=\"padding-top: 100px\"><font color=\"red\" size=\"10\">欢迎使用</font></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<div region=\"west\" style=\"width: 200px\" title=\"导航菜单\" split=\"true\">\n");
      out.write("\t<div class=\"easyui-accordion\" data-options=\"fit:true,border:false\">\n");
      out.write("\t\t<div title=\"常用操作\" data-options=\"selected:true,iconCls:'icon-item'\" style=\"padding: 10px\">\n");
      out.write("\t\t\t<a href=\"javascript:openTab('写博客','writeBlog.jsp','icon-writeblog')\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-writeblog'\" style=\"width: 150px\">写博客</a>\n");
      out.write("\t\t\t<a href=\"javascript:openTab('评论审核','commentReview.jsp','icon-review')\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-review'\" style=\"width: 150px\">评论审核</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div title=\"博客管理\"  data-options=\"iconCls:'icon-bkgl'\" style=\"padding:10px;\">\n");
      out.write("\t\t\t<a href=\"javascript:openTab('写博客','writeBlog.jsp','icon-writeblog')\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-writeblog'\" style=\"width: 150px;\">写博客</a>\n");
      out.write("\t\t\t<a href=\"javascript:openTab('博客信息管理','blogManage.jsp','icon-bkgl')\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-bkgl'\" style=\"width: 150px;\">博客信息管理</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div title=\"博客类别管理\" data-options=\"iconCls:'icon-bklb'\" style=\"padding:10px\">\n");
      out.write("\t\t\t<a href=\"javascript:openTab('博客类别信息管理','blogTypeManage.jsp','icon-bklb')\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-bklb'\" style=\"width: 150px;\">博客类别信息管理</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div title=\"评论管理\"  data-options=\"iconCls:'icon-plgl'\" style=\"padding:10px\">\n");
      out.write("\t\t\t<a href=\"javascript:openTab('评论审核','commentReview.jsp','icon-review')\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-review'\" style=\"width: 150px\">评论审核</a>\n");
      out.write("\t\t\t<a href=\"javascript:openTab('评论信息管理','commentManage.jsp','icon-plgl')\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-plgl'\" style=\"width: 150px;\">评论信息管理</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div title=\"个人信息管理\"  data-options=\"iconCls:'icon-grxx'\" style=\"padding:10px\">\n");
      out.write("\t\t\t<a href=\"javascript:openTab('修改个人信息','modifyInfo.jsp','icon-grxxxg')\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-grxxxg'\" style=\"width: 150px;\">修改个人信息</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div title=\"系统管理\"  data-options=\"iconCls:'icon-system'\" style=\"padding:10px\">\n");
      out.write("\t\t    <a href=\"javascript:openTab('友情链接管理','linkManage.jsp','icon-link')\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-link'\" style=\"width: 150px\">友情链接管理</a>\n");
      out.write("\t\t\t<a href=\"javascript:openPasswordModifyDialog()\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-modifyPassword'\" style=\"width: 150px;\">修改密码</a>\n");
      out.write("\t\t\t<a href=\"javascript:refreshSystemCache()\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-refresh'\" style=\"width: 150px;\">刷新系统缓存</a>\n");
      out.write("\t\t\t<a href=\"javascript:logout()\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'icon-exit'\" style=\"width: 150px;\">安全退出</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<div region=\"south\" style=\"height: 25px;padding: 5px\" align=\"center\">\n");
      out.write("\tCopyright © 2012-2016 史汉文的SSM博客系统 版权所有\n");
      out.write("</div>\n");
      out.write("<div id=\"dlg\" class=\"easyui-dialog\" style=\"width:400px; height:200px; padding:10px 20px\" \n");
      out.write("\tclosed=\"true\" buttons=\"#dlg-buttons\">\n");
      out.write("\t<form id=\"fm\" method=\"post\">\n");
      out.write("\t\t<table cellspacing=\"8px\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>用户名</td>\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"username\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${blogger.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly=\"readonly\">\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>新密码</td>\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t<input type=\"password\" id=\"password\" name=\"password\" class=\"easyui-validatebox\" \n");
      out.write("\t\t\t\t\t\t required=\"true\" style=\"width:200px\">\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>确认新密码</td>\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t<input type=\"password\" id=\"password2\" name=\"password2\" class=\"easyui-validatebox\" \n");
      out.write("\t\t\t\t\t\trequired=\"true\" style=\"width:200px\">\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"dlg-buttons\">\n");
      out.write("\t<div>\n");
      out.write("\t\t<a href=\"javascript:modifyPassword()\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\" plain=\"true\">保存</a>\n");
      out.write("\t\t<a href=\"javascript:closePasswordModifyDialog()\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" plain=\"true\">关闭</a>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
