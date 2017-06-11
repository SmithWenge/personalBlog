<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html>
<head>
    <link href="${contextPath}/static/bootstrap3/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/static/bootstrap-markdown/css/bootstrap-markdown.min.css" rel="stylesheet">
    <script type="text/javascript" src="${contextPath}/static/jquery/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="${contextPath}/static/bootstrap3/js/bootstrap.js"></script>
    <script type="text/javascript" src="${contextPath}/static/bootstrap-markdown/js/bootstrap-markdown.js"></script>
    <script type="text/javascript" src='${contextPath}/static/markdown-browser-0.6.0-beta1/markdown.js'></script>
    <script type="text/javascript" src="${contextPath}/static/jquery-validate/jquery.validate.js" ></script>
    <script type="text/javascript" src="${contextPath}/static/confirm/jquery.confirm.js" ></script>
</head>

<body>
    <form class="form-horizontal" style="margin-top: 20px" id="blogForm">
        <div class="form-group">
            <label for="title" class="col-sm-1 control-label">标题</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="title" name="title"/>
            </div>
        </div>
        <div class="form-group">
            <label for="blogTypeId" class="col-sm-1 control-label">所属类别</label>
            <div class="col-sm-10">
                <select class="form-control" id="blogTypeId" name="blogTypeId">
                    <option value="0">请选择博客类别...</option>
                    <c:forEach items="${blogTypeList }" var="blogType">
                        <option value="${blogType.id }">${blogType.typeName }</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="content" class="col-sm-1 control-label">博客内容</label>
            <div class="col-sm-10">
                <textarea data-savable="true" language="zh" id="content" name="content" data-provide="markdown" rows="20"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="keyWord" class="col-sm-1 control-label">关键字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="keyWord" name="keyWord" placeholder="多个关键字的话请用空格隔开"/>
            </div>
        </div>
        <hr/>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="submit" class="btn btn-default" onclick="submitData()">发布</button>
            </div>
        </div>
    </form>
</body>

<script type="text/javascript">

    // 确认提示框设置
    $.confirm.options = {
//            text: "Are you sure?",
        title: "消息提示",
        confirmButton: "确认",
        post: false,
        submitForm: false,
        confirmButtonClass: "btn-default",
        dialogClass: "modal-dialog"
    }
    var previewContent;

    $("#content").markdown({
        savable:true,language:"zh",
        onPreview: function(e) {

            if (e.isDirty()) {
                previewContent = e.parseContent();
            } else {
                previewContent = "没写字儿。。。"
            }

            return previewContent
        },
        onBlur: function(e) {
            previewContent = e.parseContent();
        }
    })

    function submitData() {
        var title = document.getElementById("title").value;
        var blogTypeId = document.getElementById("blogTypeId").value;
        var content = previewContent;
        var summary = $(previewContent).text().substr(0, 155);
        var keyWord = document.getElementById("keyWord").value;
        var contentNoTag =$(previewContent).text();

        $.post("${contextPath}/admin/blog/save.do",
                {
                    'title' : title,
                    'blogType.id' : blogTypeId,
                    'content' : content,
                    'summary' : summary,
                    'keyWord' : keyWord,
                    'contentNoTag' : contentNoTag
                }, function(result) {
                    if (result.success) {
                        $.confirm({
                            text: "博客发布成功！",
                            confirm: function() {

                            }
                        });
                        clearValues();
                    } else {
                        $.confirm({
                            text: "博客发布失败！",
                            confirm: function() {

                            }
                        });
                    }
                }, "json");
    }

    function clearValues() {
        $("#title").val("");
        $("#blogTypeId").combobox("setValue", "");
        UE.getEditor("editor").setContent("");
        $("#keyWord").val("");
    }

    $(function () {

        $('#blogForm').validate({
            rules: {
                title: {
                    required: true
                },
                content: {
                    required: true
                },
                keyWord: {
                    required: true
                },
                blogTypeId: {
                    min:1
                }
            },
            messages: {
                title: {
                    required: "请输入标题"
                },
                content: {
                    required: "请输入博客内容"
                },
                keyWord: {
                    required: "请输入关键字"
                },
                blogTypeId: {
                    min: "请选择类型"
                }
            }
        });
    });
</script>
</html>
