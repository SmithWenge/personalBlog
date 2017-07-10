<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">

	<%--function submitData(fileName) {--%>
		<%--$.post(--%>
				<%--"${contextPath}/blogger/download.do",--%>
				<%--{"fileName":fileName},--%>
				<%--function(result) {--%>
					<%--if(result.success) {--%>
						<%--alert("已下载完毕");--%>
						<%--window.location.reload();--%>
					<%--} else {--%>
						<%--alert(result.errorInfo);--%>
					<%--}--%>
				<%--},"json"--%>
		<%--);--%>

	<%--}--%>

	<%--$(".data_list.datas.download").click(function() {--%>
		<%--var fileName = $(this).attr("name"); // $(this)表示获取当前被点击元素的name值--%>
		<%--var pageData = {--%>
			<%--"fileName" : fileName--%>
		<%--}--%>
		<%--$.ajax({--%>
			<%--type: 'post',--%>
			<%--contentType: 'application/x-www-form-urlencoded',--%>
			<%--dataType: 'json',--%>
			<%--url: '${contextPath}/blogger/download.do',--%>
			<%--data: pageData,--%>
			<%--success: function (result) {--%>
				<%--if(result.success) {--%>
					<%--alert("已下载完毕");--%>
					<%--window.location.reload();--%>
				<%--} else {--%>
					<%--alert(result.errorInfo);--%>
				<%--}--%>
			<%--}--%>
		<%--});--%>
	<%--});--%>
</script>

<div class="data_list">
	<div class="data_list_title">
		<img src="${contextPath}/static/images/about_icon.png"/>&nbsp;资源小站
	</div>
	<div class="datas">
			<ul>
				<c:forEach items="${maps}" var = "map">
					<c:forEach items="${map}" var="entry"  >
						<li><a class="download" href="${contextPath}/blogger/download/${entry.key}.do">${entry.value}</a></li>
					</c:forEach>
				</c:forEach>
				<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:10px;" />																												
			</ul>			
	</div>
</div>