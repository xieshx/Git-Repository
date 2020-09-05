<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <form action="user/receiveGet.do" method="get">
        姓名：<input type="text" name="username">
        年龄：<input type="text" name="userage">
        <input type="submit" value="get请求">
    </form>
</div>

<div>
    <form action="user/receivePost.do" method="post">
        姓名：<input type="text" name="username">
        年龄：<input type="text" name="userage">
        <input type="submit" value="post请求">
    </form>
</div>

<div>
    <form action="user/receiveObject.do">
        姓名：<input type="text" name="name">
        年龄：<input type="text" name="age">
        <input type="submit" value="对象请求">
    </form>
</div>

</body>
</html>
