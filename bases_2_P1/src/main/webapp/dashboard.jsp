<%-- 
    Document   : login2
    Created on : 1 abr. 2022, 22:00:01
    Author     : joseg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                <select name="opcionesT" >
                    ${opcionesTipo}
                </select>
                <select name="opcionesT" >
                    ${opcionesSucursal}
                </select>
                <select name="opcionesT" >
                    ${opcionesProducto}
                </select>
            </div>
        </div>        
    <div class="col-4 mx-auto text-center">
        <div class="card" style="width: 18rem;">
            <i class="bi bi-signpost-2-fill icon"></i>
            <div class="card-body">
                <button class="mx-auto button-login" >
                    Comprar​
                </button>
            </div>
        </div>
     </div>
    <div class="col-4 mx-auto text-center">
        <div class="card" style="width: 18rem;">
            <i class="bi bi-signpost-2-fill icon"></i>
            <div class="card-body">
                <button class="mx-auto button-login" >
                    modificar mis datos
                </button>
            </div>
        </div>
     </div>
    <div class="col-4 mx-auto text-center">
        <div class="card" style="width: 18rem;">
            <i class="bi bi-signpost-2-fill icon"></i>
            <div class="card-body">
                <button class="mx-auto button-login" >
                    Consultar ultimos movimientos​
                </button>
            </div>
        </div>
     </div>            
    </div>
</body>
</html>
