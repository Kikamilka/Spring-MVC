<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список всех пользователях</title>
    </head>
    <body style="padding: 20px">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Все зарегистрированные пользователи:</h3>
            </div>
            <div class="panel-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Имя</th>                            
                            <th>Дата рождения</th>
                            <th>Почта</th>
                            <th>Действия</th>
                        </tr>
                    </thead>
                    <c:forEach var="users" items="${users}">
                        <tr>
                            <td><a href="/users/about/${user.id}" role="button">${user.id}</a></td>
                            <td>${user.name}</td>
                            <td>${user.birthday}</td>
                            <td>${user.email}</td>                            
                            <td><a class="btn btn-default" role="button" href="/user/delete/${user.id}">Удалить</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <a class="btn btn-default" href="/user/save" role="button">Добавить пользователя</a>
            </div>
        </div>
    </body>
</html>
