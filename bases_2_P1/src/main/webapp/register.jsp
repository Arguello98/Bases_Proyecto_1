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
        <div class="container mt-4">

            <div class="row">
                <div class="col-6 mx-auto text-center">
                    <img src="./imgs/logo.jpg" alt="logo" srcset="./imgs/logo.jpg" height="150" width="200" />
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-md-4 mx-auto border-css  border-primary rounded">

                    <form action="Registro" method="post">
                        <h1>${Error}</h1>
                        <input type="hidden" name="registro" value="1">
                        <div class="row mx-auto mt-2">
                            <div class="col-md-6 text-center mt-4">
                                <label class="label-login" for="email">Email:</label>
                            </div>
                            <div class="col-md-6 mx-auto mt-4">
                                <input
                                    class="input-login"
                                    id="email"
                                    type="email"
                                    name="email"
                                    value="${email}"
                                    />
                            </div>
                        </div>
                        <div class="row mx-auto mt-2">
                            <div class="col-md-6 text-center mt-4">
                                <label class="label-login" for="name">Nombre:</label>
                            </div>
                            <div class="col-md-6 mx-auto mt-4">
                                <input
                                    class="input-login"
                                    id="name"
                                    type="text"
                                    name="name"
                                    value="${name}"
                                    />
                            </div>
                        </div>
                        <div class="row mx-auto mt-2">
                            <div class="col-md-6 text-center mt-4">
                                <label class="label-login" for="lastname1">Primer apellido:</label>
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
                        <div class="row mx-auto mt-2">
                            <div class="col-md-6 text-center mt-4">
                                <label class="label-login" for="lastname2">Segundo apellido:</label>
                            </div>
                            <div class="col-md-6 mx-auto mt-4">
                                <input
                                    class="input-login"
                                    id="lastname2"
                                    type="text"
                                    name="lastname2"
                                    value="${lastname2}"
                                    />
                            </div>
                        </div>

                        <div class="row mx-auto mt-2">
                            <div class="col-md-6 text-center mt-4">
                                <label class="label-login" for="phone">Telefono:</label>
                            </div>
                            <div class="col-md-6 mx-auto mt-4">
                                <input
                                    class="input-login"
                                    id="phone"
                                    type="number"
                                    name="phone"
                                    value="${phone}"
                                    />
                            </div>
                        </div>
                        
                        <div class="row mx-auto mt-2">
                            <div class="col-md-6 text-center mt-4">
                                <label class="label-login" for="phone">Direccion:</label>
                            </div>
                            <div class="col-md-6 mx-auto mt-4">
                                <input
                                    class="input-login"
                                    id="Address"
                                    type="text"
                                    name="address"
                                    value="${address}"
                                    />
                            </div>
                        </div>            
                        
                        <div class="row mx-auto mt-2">
                            <div class="col-md-6 text-center mt-4">
                                <label class="label-login" for="birthDate">Fecha de nacimiento:</label>
                            </div>
                            <div class="col-md-6 mx-auto mt-4">
                                <input
                                    class="input-login"
                                    id="birthDate"
                                    type="date"
                                    name="birthDate"
                                    value="${birthDate}"
                                    />
                            </div>
                        </div>

                        <div class="row mx-auto mt-2">
                            <div class="col-md-6 text-center mt-4">
                                <label for="password">Contraseña:</label>
                            </div>
                            <div class="col-md-6 mt-4">
                                <input
                                    id="password"
                                    type="text"
                                    name="password"
                                    value="${password}"
                                    />
                            </div>
                        </div>

                        <div class="row mx-auto">
                            <div class="col-md-12 text-center mt-4 mb-4">

                                <button class="mx-auto button-login" type="submit" name="submit">
                                    REGISTRAR
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>