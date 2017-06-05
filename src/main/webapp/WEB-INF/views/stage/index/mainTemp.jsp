<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${contextPath}/static/bootstrap3/css/bootstrap.min.css">
	<link rel="stylesheet" href="${contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="${contextPath}/static/css/blog.css">
	<script src="${contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
	<script src="${contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
	<title>${title }</title>
	<script type="text/javascript">
		function changeClass(obj) {
			var li = obj.parentNode; //获取父节点
			li.className = "active";
		}
	</script>
	<style type="text/css">
		body{
			padding-top:60px;
			padding-bottom:40px;
			background-color: #F5F5F5;
			font-family: microsoft yahei;
		}

	</style>
	</head>

	<body>
		<div class="container">

			<div class="row">
				<jsp:include page="/WEB-INF/include/stage/head.jsp"/>
			</div>

			<div class="row" style="padding-top: 20px">
				<jsp:include page="/WEB-INF/include/stage/menu.jsp"/>
			</div>

			<div class="row">
				  <div class="col-md-9">
					  <jsp:include page="/WEB-INF/views/${commonPage }"/>
				  </div>
				  <div class="col-md-3">
					  <jsp:include page="/WEB-INF/views/stage/blog/rightList.jsp"/>
				  </div>
			</div>

			<div class="row">
				<jsp:include page="/WEB-INF/include/stage/footer.jsp"/>
			</div>

		</div>
	<script>
		window._bd_share_config = {
			"common" : {
				"bdSnsKey" : {},
				"bdText" : "",
				"bdMini" : "2",
				"bdMiniList" : false,
				"bdPic" : "",
				"bdStyle" : "0",
				"bdSize" : "32"
			},
			"share" : {},
			"image" : {
				"viewList" : [ "weixin", "tsina", "qzone", "tieba", "renren",
						"linkedin" ],
				"viewText" : "分享到：",
				"viewSize" : "24"
			},
			"selectShare" : {
				"bdContainerClass" : null,
				"bdSelectMiniList" : [ "weixin", "tsina", "qzone", "tieba",
						"renren", "linkedin" ]
			}
		};
		with (document)
			0[(getElementsByTagName('head')[0] || body)
					.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
					+ ~(-new Date() / 36e5)];
	</script>
	</body>
</html>