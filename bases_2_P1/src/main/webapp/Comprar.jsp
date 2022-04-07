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
        <form action="cambioPantallaUsuario" method="post">
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
            <h2> Agregar al carrito </h2>
        </div>
        <div class="row mt-2">
            <form action="operacionesCompra" method="post">
                <input type="hidden" name="operacion" value="1">
                 <label class="label-login" for="username">Producto a comprar:  </label>
                 <select name="tipoProducto">
                   ${opcionesProducto}
                 </select>
                 <label class="label-login" for="username">Cantidad:  </label>
                 <input type="number" name="cantidad">
                 <button class="mx-auto button-login" type="submit" name="submit">
                                    Agregar al carrito
                 </button>
            </form>
        </div>
        <div class="row mt-2">
            <h3>${Error}</h3>
        </div>
        <br><!-- comment -->
        <br>
        <div class="row mt-2">
            <h2>Realizar compra </h2>
        </div>
        <div class="row mt-2"> 
             <form action="operacionesCompra" method="post">
                 <input type="hidden" name="operacion" value="2">
                <label class="label-login" for="username">Sucursal para retiro:  </label>
                <select name="opcionesSucursal">
                  ${opcionesSucursal}
                </select>
                <button class="mx-auto button-login" type="submit" name="submit">
                                   Comprar
                </button>
             </form>
        </div>
        <br>
        <div class="row mt-2">
            <h2>Productos en el carrito</h2>
        </div>
        ${tablaCarrito}
    </div>
</html>
