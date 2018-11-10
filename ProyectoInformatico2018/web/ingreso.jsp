<%-- 
    Document   : ingresar.jsp
    Created on : 29-09-2018, 19:13:40
    Author     : vanes
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="scripts/ingreso.js" type="text/javascript"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Ingreso</title>
    </head>
    <body>
        <div class="sidenav">
            <form name="forma" method="post" action="index">
                <a href="ingreso.jsp">Ingresar</a>
                <a href="#" onclick="forma.submit()">Registrarse</a>
            </form>
        </div>
        <div class="main">
            <div class="container">
                <div class="card card-container">
                    <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
                    <p id="profile-name" class="profile-name-card"></p>
                    <form class="form-signin" method="post" action="ingresar">
                        <p>${message}</p>
                        <span id="reauth-email" class="reauth-email"></span>
                        <input type="email" id="inputEmail" name="txtCorreo" class="form-control" placeholder="Correo" required autofocus>
                        <input type="password" id="inputPassword" name="txtPassword" class="form-control" placeholder="Contraseña" required>
                        <div id="remember" class="checkbox">
                            <label>
                                <input type="checkbox" value="recuerdame"> Recuerdame
                            </label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Ingresar</button>
                    </form><!-- /form -->
                    <a href="#" class="forgot-password">
                        ¿Olvidó su contraseña?
                    </a>
                </div><!-- /card-container -->
            </div><!-- /container -->

        </div>
    </body>
</html>
