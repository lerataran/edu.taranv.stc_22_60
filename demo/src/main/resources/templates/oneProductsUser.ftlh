<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        .form_pro {
            width: 90%;
            height: 60%;
            margin-top: 50px;
            margin-left: 100px;
            display: block;
            box-sizing: content-box;
        }
        .product-item {

            width: 90%;
            height: 60%;
            display: inline-block;
            text-align: center;
            margin: 0 auto;
            border-bottom: 2px solid #F5F5F5;
            background: white;
            font-family: "Open Sans";
            transition: .3s ease-in;
        }
        h3 {
            text-align: left;
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
        }
        .product-list h3 {
            font-size: 18px;
            font-weight: 400;
            color: #444444;
            margin: 0 0 10px 0;
        }
        .price {
            font-size: 16px;
            color: rgb(33,147,90) ;
            display: block;
            margin-bottom: 12px;
            text-align: right;
            margin-right: 35px;
        }
        img {
            width: 300px;
            height: 300px;

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
        form {
            width: 100px;
            height: 35px;
            margin-left: 1070px;

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
<a href="/productsUser" class="button_new">Назад</a>
<div class="form_pro">
    <#list detals as product>
        <div class="product-item">
            <h3>${product.title}</h3>
            <div class="product-list">
                <img src="${product.img}" loading="lazy">
                <span class="price">Цена: ${product.price} ₽</span>
                <form action="/cart/${product.id}/add" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <button type="submit" class="registerbtn">В корзину</button>
                </form>
                <form action="" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <button type="submit" class="registerbtn">Оплатить</button>
                </form>
            </div>
        </div>
    </#list>
</div>
</body>
</html>