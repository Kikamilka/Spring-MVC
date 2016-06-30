<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список всех пользователях</title>
    </head>
    <body>
        <div>
            <div>
                <h3>Все зарегистрированные пользователи:</h3>
            </div>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Имя</th>
                            <th>Дата рождения</th>
                            <th>Почта</th>                            
                            <th>Действия</th>
                        </tr>
                    </thead>
                    <tr>
                        <td><a href="./info/${users[0].id}" role="button">${users[0].id}</a></td>
                        <td>${users[0].name}</td>
                        <td>${users[0].birthday}</td>
                        <td>${users[0].email}</td>                            
                        <td><a class="btn btn-default" role="button" href="../delete/${users[0].id}">Удалить</a></td>
                    </tr>
                    <tr>
                        <td><a href="./info/${users[1].id}" role="button">${users[1].id}</a></td>
                        <td>${users[1].name}</td>
                        <td>${users[1].birthday}</td>
                        <td>${users[1].email}</td>                            
                        <td><a class="btn btn-default" role="button" href="../delete/${users[1].id}">Удалить</a></td>
                    </tr>
                </table>
                <a class="btn btn-default" href="../addUser" role="button">Добавить пользователя</a>
            </div>
        </div>
    </body>
</html>
