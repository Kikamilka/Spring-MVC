<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Информация о пользователе</title>
    </head>
    <body>
        <div>
            <h3>Информация о пользователе:</h3>
        </div>
        <div>
            <table>
                <tr>
                    <td>Id: </td>
                    <td>${user.id}</td>
                </tr>
                <tr>
                    <td>Имя: </td>
                    <td>${user.name}</td>
                </tr>
                <tr>
                    <td>Электронная почта: </td>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <td>Дата рождения: </td>
                    <td>${user.birthday}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
