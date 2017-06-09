<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Markdown本地练习</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${contextPath}/static/bootstrap3/css/bootstrap.min.css">
    <script src="${contextPath}/static/jquery/jquery-2.1.3.js"></script>
    <script src="${contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body style="padding:30px;background:#e6e6e6;">
<div style="width:100%;padding:7px;">
    <button type="button" align="center" class="btn btn-primary btn-lg" style="font-size:30px;">
        <span class="glyphicon glyphicon-user"></span>左边输入markdown语句，右边实时预览
    </button>
</div>
<textarea id="text-input" oninput="this.editer.update()" style="width:50%;height:768px; background:#CBEFD9;font-size:22px;">
</textarea>
<div id="preview" style="float:right;width:50%;height:100%; border:0.5px solid #315;background:#e6e6e6;"></div>
<script src='${contextPath}/static/markdown-browser-0.6.0-beta1/markdown.js'></script>
<script type="text/javascript">
    function Editor(input , preview){
        this.update = function(){
            preview.innerHTML = markdown.toHTML(input.value);
        };
        input.editer = this
        this.update()
    }

    var $ = function(id) {
        return document.getElementById(id)
    }
    new Editor($("text-input"),$("preview"))
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${contextPath}/static/jquery/jquery-2.1.3.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
</body>
</html>