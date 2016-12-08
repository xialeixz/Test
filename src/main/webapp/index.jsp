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
        function callUpdate(){
            var data = {};
            data.id = $("#id").val();
            data.name = $("#name").val();
            data.idNo = $("#idNo").val();
            data.INTERFACE = "modify";

            callInterface(data, function(data){
                alert(data);
            }, function(data){
                alert(data);
            });
        }

        function callGet(){
            var data = {};
            data.id = $("#id").val();
            data.INTERFACE = "get";
            callInterface(data, function(data){
                alert(data);
            }, function(data){});
        }

        function callAdd(){
            var data = {};
            data.name = $("#name").val();
            data.idNo = $("#idNo").val();
            data.idType = $("#idType").val();
            data.title = $("#title").val();
            data.gender = $("#gender").val();
            data.birthday = $("#birthday").val();
            data.INTERFACE = "add";

            callInterface(data, function(data){
                alert(data);
            }, function(data){
                alert(data);
            });
        }

        function callInterface(data, succProc, failProc){
            $.ajax({
                type: 'POST',
                url: "interface.html?t=" + new Date().getTime(),
                dataType: 'text',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify(data),
                success: succProc,
                error: failProc
            });
        }
    </script>
</head>
<body>
<form action="home.jsp" method="post">
    <h2>数据录入</h2>
    name：<input type="text" id="name" />
    <p />
    idNo：<input type="text" id="idNo" />
    <p />
    idType：<input type="text" id="idType" />
    <p />
    title：<input type="text" id="title" />
    <p />
    gender：<input type="text" id="gender" />
    <p />
    birthday：<input type="text" id="birthday" />
    <p />
    <input type="button" onclick="callAdd()" value="添加数据">
    <input type="button" onclick="callUpdate()" value="修改数据">
    <p />
    id:<input type="text" id="id" />
    <input type="button" onclick="callGet()" value="获取">
    <p />
</form>
</body>
</html>