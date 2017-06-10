<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Markdown写博客页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/demo/demo.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
</head>
<body style="margin: 10px; font-family: microsoft yahei">

<div id="p" class="easyui-panel" title="编写博客" style="padding: 10px;">

    <table cellspacing="20px">
        <tr>
            <td width="80px" style="margin: 40px">博客标题：</td>
            <td><input type="text" id="title" name="title" style="width:400px" /></td>
        </tr>
        <tr style="margin: 40px">
            <td>所属类别：</td>
            <td><select id="blogTypeId" class="easyui-combobox"
                        name="blogType.id" style="width:154px" editable="false"
                        panelHeight="auto">
                <option value="">请选择博客类别...</option>
                <c:forEach items="${blogTypeList }" var="blogType">
                    <option value="${blogType.id }">${blogType.typeName }</option>
                </c:forEach>
            </select></td>
            <td></td>
        </tr>
        <tr>
            <td valign="top">博客内容：</td>
            <td>
                <textarea id="text-input" oninput="this.editer.update()" style="width:50%;height:500px;float: left;background:#CBEFD9;font-size:22px;"></textarea>
                <div id="preview" style="float:right;width:45%;height:200%; border:0.5px solid #315;background:#e6e6e6;"></div>
            </td>
        </tr>
        <tr>
            <td>关键字：</td>
            <td><input type="text" id="keyWord" name="keyWord"
                       style="width:400px" />&nbsp;&nbsp;&nbsp;多个关键字的话请用空格隔开</td>
        </tr>
        <tr>
            <td></td>
            <td><a href="javascript:submitData()" class="easyui-linkbutton"
                   data-options="iconCls:'icon-submit'">发布博客</a></td>
        </tr>
    </table>
</div>
<!-- markdown编辑器 -->
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

<script type="text/javascript">
    function submitData() {
        var title = $("#title").val();
        var blogTypeId = $("#blogTypeId").combobox("getValue");
        var content = UE.getEditor('editor').getContent();
        var summary = UE.getEditor('editor').getContentTxt().substr(0, 155);
        var keyWord = $("#keyWord").val();
        var contentNoTag = UE.getEditor('editor').getContentTxt();

        if (title == null || title == '') {
            $.messager.alert("系统提示", "请输入标题！");
        } else if (blogTypeId == null || blogTypeId == '') {
            $.messager.alert("系统提示", "请选择博客类型！");
        } else if (content == null || content == '') {
            $.messager.alert("系统提示", "请编辑博客内容！");
        } else {
            $.post("${pageContext.request.contextPath}/admin/blog/save.do",
                    {
                        'title' : title,
                        'blogType.id' : blogTypeId,
                        'content' : content,
                        'summary' : summary,
                        'keyWord' : keyWord,
                        'contentNoTag' : contentNoTag
                    }, function(result) {
                        if (result.success) {
                            $.messager.alert("系统提示", "博客发布成功！");
                            clearValues();
                        } else {
                            $.messager.alert("系统提示", "博客发布失败！");
                        }
                    }, "json");
        }
    }
    function clearValues() {
        $("#title").val("");
        $("#blogTypeId").combobox("setValue", "");
        UE.getEditor("editor").setContent("");
        $("#keyWord").val("");
    }
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${contextPath}/static/jquery/jquery-2.1.3.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
</body>
</html>