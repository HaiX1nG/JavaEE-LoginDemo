<%--
  Created by IntelliJ IDEA.
  User: 14654
  Date: 2023/12/22
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./css/login.css">
    <script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
    <title>Login</title>
</head>
<body>
    <div id="loginBox">
        <form action="login" method="post" id="loginForm">
            <fieldset id="fieldset">
                <legend><h4>登录页面</h4></legend>
                姓名:<input type="text" name="uname" id="uname" value="${messageModel.object.username}"><br>
                密码:<input type="password" name="uPassword" id="uPassword" value="${messageModel.object.password}"><br>
                <span id="msg" style="font-size: 12px;color: red">${messageModel.msg}</span><br>
                <button id="loginBtn">登录</button>
                <button id="registerBtn">注册</button>
            </fieldset>
        </form>
    </div>

    <script type="text/javascript">
        $(document).ready(function (){
            $('#loginBtn').click(function (){
                let uname = $('#uname').val()
                let uPassword = $('#uPassword').val()

                if (isEmpty(uname)){
                    $('#msg').html('用户姓名不可为空!')
                    return false
                }

                if (isEmpty(uPassword)){
                    $('#msg').html('用户密码不可为空!')
                    return false
                }

                $('#loginForm').submit()
            })
        })
        /**
         * 判断字符串是否为空
         * 如果为空则返回true
         * 如果不为空则返回false
         * @param str
         * @returns {boolean}
         * */
        function isEmpty(str) {
            if (str == null || str.trim() == ""){
                return true
            }
            return false
        }
    </script>
</body>

</html>
