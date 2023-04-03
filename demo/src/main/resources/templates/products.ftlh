<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        html {
            height: 100%;
        }
        body{
            background: linear-gradient(#d7d7d7, white);
            min-height: 100%;
        }
        .form_pro {
            margin-top:50px;
            box-sizing: content-box;
            display: block;
            grid-auto-flow: column;
            margin-left: 75px;
        }
        .product-item {
            width: 300px;
            display: inline-block;
            text-align: center;
            margin: 5px 15px;
            border-bottom: 2px solid #F5F5F5;
            background: white;
            font-family: "Open Sans";
            transition: .3s ease-in;
            border-radius: 10px;
        }
        .product-item:hover {
            border-bottom: 2px solid #fc5a5a;

        }
        .product-item img {
            display: block;
            width: 100%;
        }
        .product-list {
            background: #fafafa;
            padding: 15px 0;
            border-radius: 10px;
        }
        .product-list h3 {
            font-size: 18px;
            font-weight: 400;
            color: #444444;
            margin: 0 0 10px 0;
        }
        .price {
            font-size: 16px;
            color: #fc5a5a;
            display: block;
            margin-bottom: 12px;
        }
        .button {
            text-decoration: none;
            display: inline-block;
            padding: 0 12px;
            background: #cccccc;
            color: white;
            text-transform: uppercase;
            font-size: 12px;
            line-height: 28px;
            transition: .3s ease-in;
            margin-top: 10px;
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
            background-color: #fc5a5a;
            border: none;
            color: white;
            width: 100px;
            height: 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            text-transform: uppercase;
            font-size: 12px;
        }
        .registerbtn:hover {
            opacity:1;
        }
    </style>
    <title>Товары</title>
</head>

<body>
<#--<h1>Add accounts</h1>-->
<#--<form method="post" action="/accounts/add">-->
<#--    <input name="name" placeholder="Название"/>-->
<#--    <input name="price"  placeholder="Цена">-->
<#--    <input type="submit" value="Добавить"/>-->
<#--</form>-->
<#list client as client>
    <a href="/cart/${client.id}" class="button_new">Корзина</a>
</#list>
<a href="/addProducts" class="button_new">Добавить товар</a>
<a href="/profile" class="button_new">Профиль</a>

<div class="form_pro">
<#list products as product>
<div class="product-item">
    <div class="product-list">
        <h3>${product.title}</h3>
        <span class="price">${product.price} ₽</span>
        <form action="/cart/${product.id}/add" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit" class="registerbtn">В корзину</button>
        </form>
        <a href="/products/${product.id}" class="button">Детальнее</a>
    </div>
</div>
</#list>
</div>
</body>
</html>
