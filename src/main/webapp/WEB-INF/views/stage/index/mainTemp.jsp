<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	<link rel="shortcut icon" href="${contextPath}/static/userImages/title.png" />
	<script type="text/javascript">
		function changeClass(obj) {
			var li = obj.parentNode; //获取父节点
			li.className = "active";
		}
	</script>

	<%--自动推送链接到百度--%>
	<script type="text/javascript">
		(function(){
			var bp = document.createElement('script');
			var curProtocol = window.location.protocol.split(':')[0];
			if (curProtocol === 'https'){
				bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
			}
			else{
				bp.src = 'http://push.zhanzhang.baidu.com/push.js';
			}
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(bp, s);
		})();
	</script>
	<style type="text/css">
		body{
			padding-top:50px;
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
				<div class="col-xs-3">
					<jsp:include page="/WEB-INF/views/stage/blog/rightList.jsp"/>
				</div>
				<div class="col-xs-9">
					<jsp:include page="/WEB-INF/views/${commonPage }"/>
				</div>
			</div>

			<div class="row">
				<jsp:include page="/WEB-INF/include/stage/footer.jsp"/>
			</div>
		</div>
	</body>
</html>
