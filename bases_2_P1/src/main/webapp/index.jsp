<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
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
  <body>
    <div class="container">
      <h1 class="text-center">Bienvenido a Farmacia X</h1>
      <div class="row">
        <div class="col-md-2 offset-md-8">
          <button><a href="./login.jsp">Ingresar</a></button>
          <button><a href="./register.jsp">Registrarse</a></button>
          <button><a href="./loginadmin.jsp">Ingreso Colaborador</a></button>
        </div>
      </div>

      <div class="row">
        <div class="col-8 mx-auto">
          <img src="./imgs/logo.jpg" alt="logo" srcset="./imgs/logo.jpg" />
        </div>
      </div>
    </div>
  </body>
</html>
