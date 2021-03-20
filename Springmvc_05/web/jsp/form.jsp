<%--
  Created by IntelliJ IDEA.
  User: 翊
  Date: 2021/3/20
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <!--文件上传的三要素：1. type="file" 2.method="post" 3.enctype="multipart/form-data"-->
    <form action="/file/f1" method="post" enctype="multipart/form-data">
        姓名<input type="text" name="username"><br>
        文件1：<input type="file" name="file"><br>
        文件2：<input type="file" name="files"><br>
        文件2：<input type="file" name="files"><br>
        文件2：<input type="file" name="files"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
