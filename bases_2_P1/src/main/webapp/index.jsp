<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/css1.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Hola mundo!!!!</h1>
        <form action="login" method ="post">
            <pre>
                <input type ="text" name="usname" placeholder=${nombre}/>
                <input type ="text" name="pass" placeholder=${contraseña}/>
                <input type ="submit" name="submit"/>
            </pre>
        </form>
    </body>
    <a href="prueba2.jsp"> link a prueba 2</a>
</html>
