<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>第一个springmvc项目</p>
<p><a href="user/some.do">发起some.do的请求</a> </p>
<div>
    <form action="user/get.do" method="get">
        <input type="submit" value="get请求">
    </form>
</div>
<div>
    <form action="user/post.do" method="post">
        <input type="submit" value="post请求">
    </form>
</div>
</body>
</html>
