<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="data_list">
	<div class="data_list_title">
		<img src="${contextPath}/static/images/user_icon.png" />
		博主信息
	</div>
	<div style="margin: 15px 0px 0px 46px">
		<img class="img-rounded" style="width: 200px; height: 270px" src="${contextPath}/static/userImages/${blogger.imagename}" />
	</div>
	<div style="margin: 20px 0px 0px 46px">
		<h2><b>${blogger.name}</b></h2>
		<h4 style="color: #989797">${blogger.nickname}</h4>
	</div>
	<div class="data_list_title" style="margin: 17px 0px 0px 46px">
		<h5>${blogger.sign}</h5>
	</div>
	<div style="margin: 20px 0px 0px 46px">
		<img style="width: 17px; height: 17px" src="${contextPath}/static/images/map.png" />
		${blogger.address}
	</div>
	<div style="margin: 11px 0px 0px 46px">
		<img style="width: 20px; height: 20px" src="${contextPath}/static/images/email.png" />
		${blogger.email}
	</div>
	<div style="margin: 6px 0px 0px 46px">
		<img src="${contextPath}/static/images/link_icon.png" />
		<a href="http://www.cnblogs.com/Vdiao/">${blogger.linkBlog}</a>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${contextPath}/static/images/byType_icon.png" />
		文章分类
	</div>
	<div class="datas">
		<ul>
			<c:forEach items="${blogTypeList }" var="blogType">
				<li><span> <a
						href="${contextPath}/index.html?typeId=${blogType.id }">${blogType.typeName }（${blogType.blogCount }）
					</a></span></li>
			</c:forEach>
		</ul>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${contextPath}/static/images/byDate_icon.png" />
		文章存档
	</div>
	<div class="datas">
		<ul>
			<c:forEach items="${blogTimeList }" var="blog">
				<li><span> <a
						href="${contextPath}/index.html?releaseDateStr=${blog.releaseDateStr }">${blog.releaseDateStr }（${blog.blogCount }）
					</a></span></li>
			</c:forEach>
		</ul>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img src="${contextPath}/static/images/link_icon.png" />
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
			src="${contextPath}/static/images/comment_icon.png" />
		分享到
	</div>
	<div class="datas" style="margin-top: 15px">
		<ul>
			<div class="bshare-custom">
				<a title="分享到微信" class="bshare-weixin"></a>
				<a title="分享到新浪微博" class="bshare-sinaminiblog"></a>
				<a title="分享到QQ好友" class="bshare-qqim"></a><a title="分享到QQ空间" class="bshare-qzone"></a>
				<a title="更多平台" class="bshare-more bshare-more-icon more-style-addthis"></a>
				<span class="BSHARE_COUNT bshare-share-count">0</span>
			</div>
			<script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=3&amp;lang=zh"></script><script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/bshareC0.js"></script>
		</ul>
	</div>
</div>
