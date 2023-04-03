<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
    <style>
        html {
            height: 100%;
        }
        #outer
        {
            margin-top: -28px;
            width:28%;
            text-align: center;
            margin-left: 100px;
        }
        .inner
        {
            display: inline-block;
        }
        h1 {
            text-align: center;
        }
        body{
            background: linear-gradient(#d7d7d7, white);
            min-height: 100%;
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
            cursor: pointer;
        }
        a.button_new:hover { background: black; }
        a.button_new:active {
            background: black;
            box-shadow: 0 3px rgb(33,147,90) inset;
        }
        .registerbtn {

            border-radius: 3px;
            font-weight: 700;

            background-color: #fc5a5a;
            border: none;
            color: white;
            width: 120px;
            height: 43px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            text-transform: uppercase;
            font-size: 14px;
            box-shadow: 0 -3px gray inset;
        }
        .registerbtn:hover {
            opacity:1;
        }
        .register {

            border-radius: 3px;
            font-weight: 700;

            background-color: #fc5a5a;
            border: none;
            color: white;
            width: 120px;
            height: 43px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            text-transform: uppercase;
            font-size: 14px;
            box-shadow: 0 -3px gray inset;
        }
        .register:hover {
            opacity:1;
        }
        form {
            margin-left: 75px;
        }
    </style>
</head>
<body>
<a href="/logout" class="button_new">Выход</a>
<a href="/clients" class="button_new">Клиенты</a>
<#list client as client>
    <a href="/cart/${client.id}" class="button_new">Корзина</a>
<div id="outer">
    <div class="inner">
    <form action="/cart/${client.id}/pro" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit" class="register">Товары</button>
    </form>
    </div>
</div>
</#list>
<h1>Профиль!</h1>
</body>
</html>
