<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавить товар</title>
    <style>
        .form_pro {
            box-sizing: border-box;
            width: 300px;
            height: 300px;
            margin-left: 600px;}

        .container {
            padding: 16px;
        }

        input[type=text] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus {
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

<a href="/products" class="button_new">Назад</a>
<div class="form_pro">
    <#list detals as product>
    <form action="/products/${product.id}/edit" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <div class="container">
            <label for="title">Введите название товара:</label>
            <input type="text" id="title" name="title" value="${product.title}">
            <br>
            <label for="price">Введите цену товара:</label>
            <input type="text" id="price" name="price" value="${product.price}">
            <br>
            <label for="img">Вставте ссылку на изображение товара:</label>
            <input type="text" id="img" name="img" value="${product.img}">
            <input type="submit" value="Обновить" class="registerbtn">
        </div>
    </form>
    </#list>
</div>
</body>
</html>