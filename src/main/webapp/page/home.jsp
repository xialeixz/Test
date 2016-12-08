<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GB18030">
    <title>home</title>
    <script src="http://libs.baidu.com/jquery/1.3.2/jquery.min.js"></script>
    <script type="text/javascript" src="./js/json2.js">
    </script>
    <script type="text/javascript">
        function callAdd(){
            var data = {};
            data.name = $("#name").val();
            data.age = $("#age").val();
            data.nick = $("#nick").val();

            callInterface(data, function(data){
                alert(data);
            }, function(data){
                alert(data);
            })
        }

        function callInterface(data, succProc, failProc){
            $.ajax({
                type: 'POST',
                url: "interface.html?t=" + new Date().getTime(),
                dataType: 'text',
                contentType: 'application/json;charset=UTF-8',
                data: data,
                success: succProc,
                error: failProc
            });
        }
    </script>
</head>
<body>
    <h2>数据录入</h2>
    <form action="home.jsp" method="post">
        name：<input type="text" id="name" />
        <p />
        age：<input type="text" id="age" />
        <p />
        nick：<input type="text" id="nick" />
        <p />
        <input type="button" onclick="callAdd()" value="登录">
        <p />
    </form>
</body>
</html>