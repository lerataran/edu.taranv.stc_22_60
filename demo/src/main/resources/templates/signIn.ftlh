<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SignUp</title>
    <style>
        .form_pro {
            box-sizing: border-box;
            width: 300px;
            height: 300px;
            margin-left: 600px;}

        .container {
            padding: 16px;
        }

        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus  {
            background-color: #ddd;
            outline: none;
        }

        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        .registerbtn {
            background-color: #fc5a5a;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 300px;
            opacity: 0.9;
            position: relative;
        }

        .registerbtn:hover {
            opacity:1;
        }

        a {
            color: dodgerblue;
        }

        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
        a.button_new {
            font-weight: 700;
            color: white;
            text-decoration: none;
            padding: .8em 1em calc(.8em + 3px);
            border-radius: 3px;
            background: #fc5a5a;
            box-shadow: 0 -3px gray inset;
            transition: 0.2s;
        }
        a.button_new:hover { background: black; }
        a.button_new:active {
            background: black;
            box-shadow: 0 3px rgb(33,147,90) inset;
        }
    </style>
</head>
<body>
<a href="/oneProducts" class="button_new">Назад</a>
<a href="/signUp" class="button_new">Зарегестрироваться</a>
<div class="form_pro">
<form action="/signIn" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <div class="container">
    <label for="login">Ведите логин:</label>
    <input type="text" id="login" name="login">
    <br>
    <label for="password">Введите пароль:</label>
    <input type="password" id="password" name="password" >
    <input type="submit" value="Войти" class="registerbtn">
    </div>
</form>
</div>
</body>
</html>
