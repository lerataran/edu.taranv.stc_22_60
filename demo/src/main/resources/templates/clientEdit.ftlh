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

<a href="/clients" class="button_new">Назад</a>
<div class="form_pro">
    <#list client as client>
        <form action="/clients/${client.id}/edit" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <div class="container">
                <label for="title">${client.firstName} ${client.lastName}</label>
                <label for="price">Введите новую роль:</label>
                <input type="text" id="price" name="price" value="${client.role}">
                <input type="submit" value="Обновить" class="registerbtn">
            </div>
        </form>
    </#list>
</div>
</body>
</html>