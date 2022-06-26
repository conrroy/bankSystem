<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QWERTY Back System</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <style>
    * {
        margin: 0;
        padding: 0;
    }
    html {
        height: 100%;
    }
    body {
        height: 100%;
    }
    .container {
        height: 100%;
        background-image: url("assets/bg.png");
    }
    .login-wrapper {
        background-color: #fff;
        width: 358px;
        height: 588px;
        border-radius: 15px;
        padding: 0 50px;
        position: relative;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }
    .header {
        font-size: 14px;
        font-weight: bold;
        text-align: center;
        line-height: 200px;
    }
    .input-item {
        display: block;
        width: 100%;
        margin-bottom: 20px;
        border: 0;
        padding: 10px;
        border-bottom: 1px solid rgb(128, 125, 125);
        font-size: 15px;
        outline: none;
    }
    .input-item:placeholder {
        text-transform: uppercase;
    }
    .btn {
        text-align: center;
        padding: 10px;
        width: 100%;
        margin-top: 40px;
        background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
        color: #fff;
    }
    .msg {
        text-align: center;
        line-height: 88px;
    }
    a {
        text-decoration-line: none;
        color: #abc1ee;
    }
    </style>
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">Welcome to QWERTY Banking Corporation</div>
        <div class="form-wrapper">
            <input type="text" id="username" name="username" placeholder="your emails address" class="input-item">
            <input type="password" id="password" name="password" placeholder="password" class="input-item">
            <div class="btn" id="signIn">signIn</div>
        </div>
        <div class="msg">
            Don't have account?
            <a href="login">Pls contact QWERTY!</a>
        </div>
    </div>
</div>
</body>
<script>
    $(function () {
        $('#signIn').click(function () {
            const username = $('#username').val()
            const password = $('#password').val()
            $.get('login/signIn', {username, password}, (res) => {
                console.log(res)
                window.location.href = '/home'
            })
        })
    })
    function signIn() {
        const httpRequest = new XMLHttpRequest();
        httpRequest.open('GET', 'login/signIn?name=jack&password=123456', true);
        httpRequest.send();
        httpRequest.onreadystatechange = function () {
            if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                const json = httpRequest.responseText;
                console.log(json);
            }

            if (httpRequest.readyState == 2 && httpRequest.status == 200) {
                window.location = httpRequest.getResponseHeader('Location')
            }
        };

    }
</script>
</html>
