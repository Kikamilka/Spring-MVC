<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td><a href="./info/${user.id}" role="button">${user.id}</a></td>
                            <td>${user.name}</td>
                            <td>${user.birthday}</td>
                            <td>${user.email}</td>                            
                            <td><a role="button" href="/ServiceEvent/user/delete/${user.id}">Удалить</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="../addUser" role="button">Добавить пользователя</a>
            </div>
        </div>
    </body>
</html>
