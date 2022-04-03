<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link href="styles/css1.css" rel="stylesheet" type="text/css">-->
    </head>
    <body>
        <h1>Hola mundo!!!!</h1>
        <%
            if(request.getSession().getAttribute("nombre") == null){
                //request.setAttribute("nombre", "Daniel");
                //request.getRequestDispatcher("/preuba2.jsp").forward(request, response);
            }
        %>
        <button formaction="login" formmethod="post" formtype="submit">Click Me!</button>
        
        <h1></h1>
        <form action="login" method ="post">
            <h1>${Error}</h1>
            <select id="isTitles" name = "selector">
                   ${options}
            </select>
            <pre>
                <input type ="text" name="usname" value=${nombre} >
                <input type ="text" name="pass" value=${contraseña} >
                <input type ="submit" name="submit"/>
            </pre>
        </form>
    </body>
    <a href="preuba2.jsp"> link a prueba 2</a>
</html>
