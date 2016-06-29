<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить нового пользователя</title>
    </head>
    <body>
        <div>
            <div>
                <h3>Добавление пользователя</h3>
            </div>
            <div>
                <form method="POST" action="./user/addUser">
                    <div>
                        <label for="name">Имя</label>
                        <input type="text" id="name" placeholder="Имя" name="name"/>
                    </div>
                    <br>
                    <div>
                        <label for="email">Электронная почта</label>
                        <input type="email" id="email" placeholder="Электронная почта" name="email"/>
                    </div>
                    <br>
                    <div>
                        <label for="birthday">Дата рождения</label>
                        <input type="date" id="birthday" placeholder="Дата рождения" name="birthday"/>
                    </div>
                    <br>
                    <button type="submit">Сохранить</button>
                    <input type="submit" value="Отмена" formmethod="GET" formaction="/user/allUsers"/>
                </form>
            </div>
        </div>
    </body>
</html>
