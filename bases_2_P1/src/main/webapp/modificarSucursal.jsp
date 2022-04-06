<%-- 
    Document   : modificarSucursal
    Created on : 5 abr. 2022, 18:05:01
    Author     : Persona
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
        <form action="cambioPantalla" method="post">
           <input type="hidden" name="cambio" value="2">
           <input type="submit" value="volver">
        </form>
        <form action="cambioPantalla" method="post">
           <input type="hidden" name="cambio" value="0">
           <input type="submit" value="Menu Principal">
        </form>
        <div class="row mt-4">
            
                <div class="col-md-4 mx-auto border-css  border-primary rounded">
                    <form action="operacionesSucursal" method="post">
                        <h1>${Error}</h1>
                        <input type="hidden" name="operacion" value="4">
                        <input type="hidden" name="id_modificar" value=${sucursal_id}>
                        <div class="row mx-auto mt-2">
                            <div class="col-md-6 text-center mt-4">
                                <label class="label-login" for="email">Nombre</label>
                            </div>
                            <div class="col-md-6 mx-auto mt-4">
                                <input
                                    class="input-login"
                                    id="email"
                                    type="text"
                                    name="sucursal_nombre"
                                    value="${sucursal_nombre}"
                                    />
                            </div>
                        </div>
                        <div class="row mx-auto mt-2">
                            <div class="col-md-6 text-center mt-4">
                                <label class="label-login" for="name">Descripcion</label>
                            </div>
                            <div class="col-md-6 mx-auto mt-4">
                                <input
                                    class="input-login"
                                    id="name"
                                    type="text"
                                    name="sucursal_descripcion"
                                    value="${sucursal_descripcion}"
                                    />
                            </div>
                        </div>
                        <div class="row mx-auto">
                            <div class="col-md-12 text-center mt-4 mb-4">
                                <button class="mx-auto button-login" type="submit" name="submit">
                                    Modificar
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
    </body>
</html>
