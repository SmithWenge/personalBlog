<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${contextPath}/static/images/search_icon.png" />&nbsp;
			搜索&nbsp;<font color="red">${q }</font>&nbsp;的结果&nbsp;(共搜索到&nbsp;${resultTotal }&nbsp;条记录)
	</div>
	<div class="datas search">
		<ul>
			<c:choose>
				<c:when test="${blogIndexList.size()==0 }">
					<div align="center" style="padding-top:20px">未查询到结果，请换个关键字试试>_<</div>
				</c:when>
				<c:otherwise>
					<c:forEach items="${blogIndexList }" var="blog">
						 <li style="margin-bottom: 20px">
						  	<span class="title">
						  		<img alt="文章类型" src="${contextPath}/static/images/yuan.jpg">
						  		<a href="${contextPath}/blog/articles/${blog.id }.html" target="_blank">${blog.title }</a></span>
						  	<span class="summary">摘要: ${blog.content }...</span>
						  	<span class="link"><a href="${contextPath}/blog/articles/${blog.id }.html">${contextPath}/blog/articles/${blog.id }.html</a>&nbsp;&nbsp;&nbsp;&nbsp;修改日期：${blog.releaseDateStr }</span>
						 </li>						
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	${pageCode }
</div>