<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Клиенты</title>
    <style>
        .block{
            text-align: center;
            display: flex;
            flex-direction: row;
            justify-content: flex-start;
            border: 5px solid black;
            padding: 20px;
            width: 70%;
            margin-left: 200px;
            font-family: "Open Sans";
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
            margin-left: 5px;
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
        .fname, .lfname {
            width: 200px;
        }
        .id_cl {
            margin-left: 100px;
            width: 50px;
        }
        .logi {
            width: 200px;
        }
    </style>
</head>
<body>
<#--<h1>Add accounts</h1>-->
<#--<form method="post" action="/accounts/add">-->
<#--    <input name="name" placeholder="Название"/>-->
<#--    <input name="price"  placeholder="Цена">-->
<#--    <input type="submit" value="Добавить"/>-->
<#--</form>-->
<a href="/" class="button_new">Профиль</a>
<h1>Клиенты:</h1>
    <#list clients as client>
        <div class="block">
            <div class="id_cl">ID: ${client.id}</div>
            <div class="fname">Имя: ${client.firstName}</div>
            <div class="lfname">Фамилия: ${client.lastName}</div>
            <div class="logi">Логин: ${client.login}</div>
            <a href="/clients/${client.id}/edit" class="button">Изменить</a>
<#--            <a href="/clients/${client.id}/delete" class="button">Удалить</a>-->
        </div>
    </#list>
</body>
</html>
