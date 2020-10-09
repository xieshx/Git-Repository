<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                // alert("点击了！");
                $.get(
                    // "user/returnAjax.do",
                    // "user/returnJson.do",
                    // "user/returnList.do",
                    "user/returnString.do",
                    {"name":"张三","age":"18"},
                    function (data) {
                        alert(data)
                        // alert(data.name+"   "+data.age)
                        // $.each(data,function (i,n) {
                        //     alert(n.name+"   "+n.age)
                        // })
                    },
                    // "json"
                )
            })
        })
    </script>
</head>
<body>

<div>
    <form action="user/return.do" method="get">
        姓名：<input type="text" name="name">
        年龄：<input type="text" name="age">
        <input type="submit" value="提交">
    </form>
</div>

<div>
    <button id="btn">发起ajax请求</button>
</div>

</body>
</html>
