<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Service orders</title>
    </head>
    <body>
        <h1> Hello! It's event service! </h1>

        <form action="./user/allUsers/">
            <div>
                <h3>Получить информацию о всех пользователях:</h3>
            </div>
            <div>
                <input type="submit" value="Да, хочу!">
            </div>
        </form>

        <form action="./event/allEvents/">
            <div>
                <h3>Получить информацию о всех событиях:</h3>
            </div>
            <div>
                <input type="submit" value="Да, хочу!">
            </div>
        </form>
    </body>
</html>
