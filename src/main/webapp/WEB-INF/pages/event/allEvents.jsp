<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All events</title>
    </head>
    <body>
        <div>
            <h3>Все зарегистрированные события:</h3>
        </div>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Название</th>
                        <th>Дата и время начала</th>
                        <th>Статус</th>
                        <th>Базовая цена билета</th>
                        <th>Базовая цена билета для vip-мест</th>
                    </tr>
                </thead>
                <c:forEach var="event" items="${events}">
                    <tr>
                        <td><a href="/event/info/${event.name}" role="button">${event.name}</a></td>
                        <td>${event.airDate} ${event.airTime}</td>
                        <td>${event.rating}</td>
                        <td>${event.price}</td>
                        <td>${event.auditorium}</td>
                        <td><a class="btn btn-default" role="button" href="/event/eventDelete/${event.name}">Удалить</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
