<%-- 
    Document   : colaborador
    Created on : 6 abr. 2022, 18:12:50
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
        <form action="cambioPantalla" method="post">
            <input type="hidden" name="cambio" value="0">
            <input type="submit" value="volver">
        </form>
        <div class="row">
            <div class="col-6 mx-auto mt-2 text-center">
                <img src="./imgs/logo.jpg" alt="logo" srcset="./imgs/logo.jpg" height="150" width="200" />
            </div>
        </div>
        <br><!-- comment -->
        <br>
        <div class="row mt-2">
            <h2> Crear Colaborador </h2>

        </div>
        <div class="row mt-2">
            <div class="col-md-6 mx-auto border-css text-center border-primary rounded">

                <form action="colaborador" method="post" >
                    <input type="hidden" name="operacion" value="1">
                    <div class=" row  mt-2">
                        <div class=" col-12 mx-auto mt-2">
                            <label class="label-login" for="tipoColaborador">Tipo:</label>
                            <select name="tipoColaborador">
                                ${opcionesTipo}
                            </select>

                            <label class="label-login" for="sucursal">Sucursal</label>
                            <select name="sucursal">
                                ${opcionesSucursal}
                            </select>
                        </div>
                    </div>

                    <div class=" row mx-auto mt-2">
                        <div class=" col-12 mx-auto mt-2">
                            <label class="label-login" for="nombreColaborador">Nombre:  </label>
                            <input type="text" name="nombreColaborador">
                        </div>
                    </div> 

                    <div class=" row mx-auto mt-2">
                        <div class=" col-12 mx-auto mt-2">
                            <label class="label-login" for="primerApellidoColaborador">Primer apellido  </label>
                            <input type="text" name="primerApellidoColaborador">
                        </div> 
                    </div> 
                    <div class=" row mx-auto mt-2">
                        <div class=" col-12 mx-auto mt-2">
                            <label class="label-login" for="segundoApellidoColaborador">Segundo apellido  </label>
                            <input type="text" name="segundoApellidoColaborador">
                        </div>
                    </div> 
                    <div class=" col-12 mx-auto mt-2">
                        <label class="label-login" for="username">Direccion</label>
                        <input type="text" name="direccionColaborador">
                    </div>

                    <div class=" col-12 mx-auto mt-2">
                        <label class="label-login" for="username">Fecha nacimiento</label>
                        <input type="date" name="fechaNacimientoColaborador">
                    </div>

                    <div class=" col-12 mx-auto mt-2">
                        <label class="label-login" for="username">Correo</label>
                        <input type="text" name="correoColaborador">
                    </div>

                    <div class=" col-12 mx-auto mt-2">
                        <label class="label-login" for="phoneColaborador">Telefono</label>
                        <input type="text" name="phoneColaborador">
                    </div>

                    <div class=" col-12 mx-auto mt-2">
                        <label class="label-login" for="username">Contraseña</label>
                        <input type="text" name="passwordColaborador">
                    </div>

                    <div class=" col-12 mx-auto mt-2">
                        <button class="mx-auto mt-2 mb-4 button-login" type="submit" name="submit">
                            Crear
                        </button>
                    </div>

                </form>
            </div>
            <div class="row mt-2">
                <h3>${Error}</h3>
            </div>
            <br><!-- comment -->
            <br>
            <div class="row mt-2">
                <h2> Eliminar Colaborador </h2>
            </div>
            <div class="row mt-2">
                <form action="colaborador" method="post">
                    <input type="hidden" name="operacion" value="2">
                    <label class="label-login" for="username">Eliga el Colaborador que quiere eliminar</label> 
                    <select name="tipoEliminar">
                        ${opcionesColaborador}
                    </select>
                    <button class="mx-auto mt-2 button-login" type="submit" name="submit">
                        Eliminar
                    </button>
                </form>
            </div>
            <br><!-- comment -->
            <br>
            <div class="row mt-2">
                <h2>Modificar Colaborador </h2>
            </div>
            <div class="row mt-2">
                <form action="colaborador" method="post">
                    <input type="hidden" name="operacion" value="3">
                    <label class="label-login" for="username">Eliga el Colaborador que quiere Modificar</label> 
                    <select name="tipoModificar">
                        ${opcionesColaborador}
                    </select>
                    <button class="mx-auto mt-2 mb-4 button-login" type="submit" name="submit">
                        Modificar
                    </button>
                </form>
            </div>
            <br><!-- comment -->
            <br>
            <div class="row mt-2">
                <h2>Tabla de informacion </h2>
            </div>
            <div class="row mt-2">
                  ${tablaColaboradores}
            </div>
        </div>
    </div>
</body>
</html>
