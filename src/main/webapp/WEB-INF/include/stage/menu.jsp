<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">
	function checkData() {

		var q = document.getElementById("q").value.trim();
		if(q == null || q == "") {
			alert("请输入您要查询的关键字！");
			return false;
		} else {
			return true;
		}
	}
</script>

<div class="col-xs-12">
	<div class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<%--<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
			<ul class="nav navbar-nav">
				<li><a class="navbar-brand" href="${pageContext.request.contextPath}/index.html" onclick="changeClass(this)">博客首页</a></li>
				<li><a class="navbar-brand" href="${pageContext.request.contextPath}/blogger/aboutme.html" onclick="changeClass(this)">关于博主</a></li>
				<li><a class="navbar-brand" href="${pageContext.request.contextPath}/blogger/tools.html" onclick="changeClass(this)">工具站</a></li>
				<li><a class="navbar-brand" href="${pageContext.request.contextPath}/blogger/resource/.html" onclick="changeClass(this)">资源站</a></li>
				<li><a class="navbar-brand" href="http://www.cnblogs.com/Vdiao/" target="blank">我的博客园首页</a></li>
			</ul>
			<form action="${pageContext.request.contextPath}/blog/search.html" class="navbar-form navbar-right" role="search" method="post" onsubmit="return checkData()">
				<div class="form-group">
					<input style="width: 200px" type="text" id="q" name="q" value="${q }" class="form-control" placeholder="请输入要查询的关键字">
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</form>
			<%--</div><!-- /.navbar-collapse -->--%>
		</div><!-- /.container-fluid -->
	</div>
</div>

