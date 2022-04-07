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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

        <link href="./styles/css.css" rel="stylesheet" type="text/css" />

        <title>Farmacia X</title>
    </head>
</head>
<body>
    <h1 class="mx-auto text-center">PANEL ADMINISTRADOR</h1>
    <div class="container">

        <div class="row mt-2">
            <div class="col-4 mx-auto text-center">
                <div class="card" style="width: 18rem;">
                    <i class="bi bi-file-person icon"></i>
                    <div class="card-body">
                        <form action="cambioPantalla" method="post">
                            <input type="hidden" name="cambio" value="1">
                            <input type="submit" value="Administrar Tipos">
                        </form>
                    </div>
                </div>

            </div>
            <div class="col-4 mx-auto text-center">
                <div class="card" style="width: 18rem;">
                    <i class="bi bi-journal-text icon"></i>
                    <div class="card-body">
                        <form action="cambioPantalla" method="post">
                            <input type="hidden" name="cambio" value="2">
                            <input type="submit" value="administrar Sucursal">
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-4 mx-auto text-center">
                <div class="card" style="width: 18rem;">
                    <i class="bi bi-person-lines-fill icon"></i>
                    <div class="card-body">
                        <form action="cambioPantalla" method="post">
                            <input type="hidden" name="cambio" value="3">
                            <input type="submit" value="administrar Producto">
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-4 mx-auto text-center">
                <div class="card" style="width: 18rem;">
                    <i class="bi bi-journal-text icon"></i>
                    <div class="card-body">
                        <form action="cambioPantalla" method="post">
                            <input type="hidden" name="cambio" value="4">
                            <input type="submit" value="administrar Proveedor">
                        </form>
                    </div>
                </div>

            </div>
            <div class="col-4 mx-auto text-center">
                <div class="card" style="width: 18rem;">
                    <i class="bi bi-signpost-2-fill icon"></i>
                    <div class="card-body">
                       <form action="cambioPantalla" method="post">
                            <input type="hidden" name="cambio" value="5">
                            <input type="submit" value="administrar Colaborador">
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-4 mx-auto text-center">
                <div class="card" style="width: 18rem;">
                    <i class="bi bi-card-checklist icon"></i>
                    <div class="card-body">
                        <form action="cambioPantalla" method="post">
                            <input type="hidden" name="cambio" value="6">
                            <input type="submit" value="Mostrar Bitacora">
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-4 mx-auto text-center">
                <div class="card" style="width: 18rem;">
                    <i class="bi bi-wallet-fill icon"></i>
                    <div class="card-body">
                        <button class="mx-auto button-login" >
                            Administrar admin​
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-4 mx-auto text-center">
                <div class="card" style="width: 18rem;">
                    <i class="bi bi-x-octagon-fill icon"></i>
                    <div class="card-body">
                        <button class="mx-auto button-login" >
                            XXXXXX
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-4 mx-auto text-center">
                <div class="card" style="width: 18rem;">
                    <i class="bi bi-x-octagon-fill icon"></i>
                    <div class="card-body">
                        <button class="mx-auto button-login" >
                            XXXXXX
                        </button>
                    </div>
                </div>
            </div>
        </div>
        

    </div>


</body>
</html>
