<%-- 
    Document   : Comprar
    Created on : Apr 6, 2022, 9:38:10 PM
    Author     : frug5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
            />

        <link href="./styles/css.css" rel="stylesheet" type="text/css" />

        <title>Farmacia X</title>
    </head>
</head>
<body>
    <div class="container mt-4">
        <div class="row">
            <div class="col-6 mx-auto text-center">
                <img src="./imgs/logo.jpg" alt="logo" srcset="./imgs/logo.jpg" height="150" width="200" />
    <div class="row mx-auto mt-2">
            <div class="col-md-6 text-center mt-4">
                 <label class="label-login" for="lastname1">Producto</label>
                <select name="opcionesT" >
                    ${opcionesTipo}
                </select>
                <label class="label-login" for="lastname1">Cantidad:</label>
            </div>
            <div class="col-md-6 mx-auto mt-4">
                <input
                    class="input-login"
                    id="lastname1"
                    type="text"
                    name="lastname1"
                    value="${lastname1}"
                    />
            </div>
                        </div>
                
                
                
    <div class="row mt-2">
        <div class="col-4 mx-auto text-center">
            <div class="card" style="width: 18rem;">
                <i class="bi bi-file-person icon"></i>
                <div class="card-body">
                    <form action="cambioPantalla" method="post">
                        <input type="hidden" name="cambio" value="1">
                        <input type="submit" value="Comprar">
                    </form>
                </div>
            </div>
</html>
