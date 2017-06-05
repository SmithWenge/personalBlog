<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="data_list">
	<div class="data_list_title">
		<img src="${pageContext.request.contextPath}/static/images/user_icon.png" />
		博主信息
	</div>
	<div style="margin: 15px 0px 0px 46px">
		<img class="img-rounded" style="width: 200px; height: 270px" src="${pageContext.request.contextPath}/static/userImages/${blogger.imagename}" />
	</div>
	<div style="margin: 20px 0px 0px 46px">
		<h2><b>${blogger.name}</b></h2>
		<h4 style="color: #989797">${blogger.nickname}</h4>
	</div>
	<div class="data_list_title" style="margin: 17px 0px 0px 46px">
		<h5>${blogger.sign}</h5>
	</div>
	<div style="margin: 20px 0px 0px 46px">
		<img style="width: 17px; height: 17px" src="${pageContext.request.contextPath}/static/images/map.png" />
		${blogger.address}
	</div>
	<div style="margin: 7px 0px 0px 46px">
		<img style="width: 20px; height: 20px" src="${pageContext.request.contextPath}/static/images/email.png" />
		${blogger.email}
	</div>
	<div style="margin: 7px 0px 0px 46px">
		<img src="${pageContext.request.contextPath}/static/images/link_icon.png" />
		<a href="http://www.cnblogs.com/Vdiao/">${blogger.linkBlog}</a>
	</div>
	<%--<div class="nickName"><strong><font style="color: #EE6A50">昵称：${blogger.nickname }</font></strong></div>--%>
	<%--<div class="userSign">『<strong><font style="color: #EE6A50">${blogger.sign }</font></strong>』</div>--%>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/byType_icon.png" />
		文章分类
	</div>
	<div class="datas">
		<ul>
			<c:forEach items="${blogTypeList }" var="blogType">
				<li><span> <a
						href="${pageContext.request.contextPath}/index.html?typeId=${blogType.id }">${blogType.typeName }（${blogType.blogCount }）
					</a></span></li>
			</c:forEach>
		</ul>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/byDate_icon.png" />
		文章存档
	</div>
	<div class="datas">
		<ul>
			<c:forEach items="${blogTimeList }" var="blog">
				<li><span> <a
						href="${pageContext.request.contextPath}/index.html?releaseDateStr=${blog.releaseDateStr }">${blog.releaseDateStr }（${blog.blogCount }）
					</a></span></li>
			</c:forEach>
		</ul>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img src="${pageContext.request.contextPath}/static/images/link_icon.png" />
		友情链接
	</div>
	<div class="datas">
		<ul>
			<c:forEach items="${linkList }" var="link">
				<li><span><a href="${link.linkurl }" target="_blank">${link.linkname }</a></span></li>
			</c:forEach>
		</ul>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/comment_icon.png" />
		分享到
	</div>
	<div class="datas">
		<ul>
			<div style="text-align:left;padding-top:20px;">
				<div class="bdsharebuttonbox">
					<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
					<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
					<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
					<a href="#" class="bds_tieba" data-cmd="tieba" title="分享到百度贴吧"></a>
					<a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
					<a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a>
					<a href="#" class="bds_more" data-cmd="more"></a>
				</div>
			</div>
		</ul>
	</div>
</div>
