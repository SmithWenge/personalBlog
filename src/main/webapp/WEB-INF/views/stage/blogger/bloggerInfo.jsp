<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<div class="data_list">
	<div class="data_list_title">
		<img src="${contextPath}/static/images/about_icon.png"/>&nbsp;关于博主
	</div>	
	<div class="datas" style="margin-left: 10px">
		${blogger.profile }
	</div>
</div>