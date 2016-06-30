<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info about this event</title>
    </head>
    <body>
        <div>
            <h3>Информация о событии:</h3>
        </div>
        <div>
            <table>
                <tr>
                    <td>Название: </td>
                    <td>${event.name}</td>
                </tr>
                <tr>
                    <td>Дата и время начала: </td>
                    <td>${event.airDate} ${event.airTime}</td>
                </tr>
                <tr>
                    <td>Статус: </td>
                    <td>${event.rating}</td>
                </tr>
                <tr>
                    <td>Базовая стоимость билета: </td>
                    <td>${event.price}</td>
                </tr>
                <tr>
                    <td>Местоположение: </td>
                    <td>${event.auditorium}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
