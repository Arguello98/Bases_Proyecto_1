<%-- 
    Document   : nuevaPantalla
    Created on : 5 abr. 2022, 14:55:35
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
    <div class="container mt-4">
        <form action="cambioPantalla" method="post">
           <input type="hidden" name="cambio" value="0">
           <input type="submit" value="volver">
        </form>
        <div class="row">
            <div class="col-6 mx-auto text-center">
                <img src="./imgs/logo.jpg" alt="logo" srcset="./imgs/logo.jpg" height="150" width="200" />
            </div>
        </div>
        <br><!-- comment -->
        <br>
        <div class="row mt-2">
            <h2> Crear Tipos </h2>
        </div>
        <div class="row mt-2">
            <form action="operacionesTipo" method="post">
                <input type="hidden" name="operacion" value="1">
                 <label class="label-login" for="username">Nombre del Tipo:  </label>
                 <input type="text" name="nombreTipo">
                 <button class="mx-auto button-login" type="submit" name="submit">
                                    Crear
                 </button>
            </form>
        </div>
        <div class="row mt-2">
            <h3>${Error}</h3>
        </div>
        <br><!-- comment -->
        <br>
        <div class="row mt-2">
            <h2> Eliminar Tipo </h2>
        </div>
        <div class="row mt-2">
            <form action="operacionesTipo" method="post">
               <input type="hidden" name="operacion" value="2">
               <label class="label-login" for="username">Eliga el tipo que quiere eliminar</label> 
               <select name="tipoEliminar">
                   ${opcionesTipo}
               </select>
               <button class="mx-auto button-login" type="submit" name="submit">
                                    Eliminar
                 </button>
            </form>
        </div>    
    </div>
</body>
</html>

