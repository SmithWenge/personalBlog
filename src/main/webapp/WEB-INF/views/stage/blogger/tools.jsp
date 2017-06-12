<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link href="${contextPath}/static/Farbtastic-Color-Picker-master/farbtastic.css" rel="stylesheet" type="text/css">
<div class="data_list">
  <div class="data_list_title">
    <img src="${contextPath}/static/images/about_icon.png"/>&nbsp;工具站
  </div>
  <h3 style="margin-left: 20px">颜色选择器</h3>
  <hr>
  <div style="margin-left: 20px">
    <div>
      <label for="color" style="margin-top: 7px;margin-left: 40px">请移动圆圈选择颜色</label>
      <input style="width: 10%;margin-left: 10px" type="text" id="color" name="configColor" value="#000000"/>
    </div>
    <div style="margin-top: 30px" id="colorpicker"></div>
  </div>
  <hr style="height:5px;border:none;border-top:1px solid  #999;padding-bottom:10px;" />
</div>


<script type="text/javascript" src="${contextPath}/static/Farbtastic-Color-Picker-master/farbtastic.js" ></script>
<script type="text/javascript">
  $(document).ready(function() {
    $('#colorpicker').farbtastic('#color');
  });
</script>