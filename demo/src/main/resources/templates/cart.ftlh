<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Корзина</title>
    <style>
        html {
            height: 100%;
        }
        .prod{
            position: absolute;

            margin-top: -17px;
        }
        h1 {
           text-align: center;
        }
        .block{
            text-align: center;
            display: flex;
            flex-direction: row;
            justify-content: flex-start;
            border: 5px solid black;
            padding: 20px;
            width: 60%;
            margin-left: 260px;
            font-family: "Open Sans";
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
        }
        a.button_new:hover { background: black; }
        a.button_new:active {
            background: black;
            box-shadow: 0 3px rgb(33,147,90) inset;
        }
        .registerbtn {
            border-radius: 3px;
            font-weight: 700;
            margin-left: 115px;
            margin-top: -100px;
            background-color: #fc5a5a;
            border: none;
            color: white;
            width: 120px;
            cursor: pointer;
            height: 47px;
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
        .registerbtn:hover {
            opacity:1;
        }
        .price{
            margin-left: 50px;
        }
        .title {
            width: 400px;
            margin-left: 100px;
        }
        .opl {
            width: 100px;
            height: 35px;
            margin-left: 1070px;
        }
        .probel {
            width: 100px;
        }
    </style>
</head>
<body>
<a href="/profile" class="button_new">Профиль</a>
<#list client as client>
<form class="prod" action="/cart/${client.id}/pro" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <button type="submit" class="registerbtn">Товары</button>
</form>
</#list>
    <h1>Корзина!</h1>

<#list product as product>
<div class="block">
    <div class="title">${product.title}</div>
    <div class="probel"></div>
    <div class="price">Цена: ${product.price} ₽</div>
<#--    <th>-->
<#--        <a href="/clients/${client.id}/delete">Удалить</a>-->
<#--    </th>-->
</div>
</#list>

<form class="opl" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <button type="submit" class="registerbtn">Оплатить</button>
</form>
</body>
</html>
