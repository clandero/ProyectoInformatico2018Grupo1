<%-- 
    Document   : registro.jsp
    Created on : 27-09-2018, 0:00:22
    Author     : vanes
--%>


<%--@page contentType="text/html" pageEncoding="UTF-8"--%>
<!DOCTYPE html>
<html>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <style>
            body {
                font-family: "Lato", sans-serif;
            }

            .sidenav {
                height: 100%;
                width: 160px;
                position: fixed;
                z-index: 1;
                top: 0;
                left: 0;
                background-color: #111;
                overflow-x: hidden;
                padding-top: 20px;
            }

            .sidenav a {
                padding: 6px 8px 6px 16px;
                text-decoration: none;
                font-size: 25px;
                color: #818181;
                display: block;
            }

            .sidenav a:hover {
                color: #f1f1f1;
            }

            .main {
                margin-left: 160px; /* Same as the width of the sidenav */
                font-size: 20px; /* Increased text to enable scrolling */
                padding: 0px 10px;
            }

            @media screen and (max-height: 450px) {
                .sidenav {padding-top: 15px;}
                .sidenav a {font-size: 18px;}
            }

            /* Change the link color on hover */
            contenido{ 
                position: absolute;
                padding-top: 0px;
                padding-left: 200px;
            }
            /*radio buttons*/
            .container {
                display: block;
                position: relative;
                padding-left: 35px;
                margin-bottom: 12px;
                cursor: pointer;
                font-size: 16px;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }       

            /* Hide the browser's default radio button */
            .container input {
                position: absolute;
                opacity: 0;
                cursor: pointer;
            }

            /* Create a custom radio button */
            .checkmark {
                position: absolute;
                top: 0;
                left: 0;
                height: 15px;
                width: 15px;
                background-color: #eee;
                border-radius: 50%;
            }

            /* On mouse-over, add a grey background color */
            .container:hover input ~ .checkmark {
                background-color: #333;
            }

            /* When the radio button is checked, add a blue background */
            .container input:checked ~ .checkmark {
                background-color: #2196F3;
            }

            /* Create the indicator (the dot/circle - hidden when not checked) */
            .checkmark:after {
                content: "";
                position: absolute;
                display: none;
            }

            /* Show the indicator (dot/circle) when checked */
            .container input:checked ~ .checkmark:after {
                display: block;
            }

            /* Style the indicator (dot/circle) */
            .container .checkmark:after {
                top: 5px;
                left: 5px;
                width: 5px;
                height: 5px;
                border-radius: 50%;
                background: white;
            }


        </style>

    </head>
    <body>
        <div class="sidenav">
            <a href="ingresar.jsp">Ingresar</a>
            <a href="registro.jsp">Registrarse</a>
        </div>

        <div class="main">
            <h1>REGISTRO</h1>
            <form method="post" action="registrar">
                <p>Llene los siguientes campos: </p><br />
                Nombre: <input type="text" name="txtNombre" /><br/><br/>
                Correo udec: <input type="text" name="txtCorreo" /><br /><br/>
                Tipo de usuario: 
                <div class="select">
                    <select name="search_categories" id="search_categories">
                        <option value="Docente" selected="selected">Docente</option>
                        <option value="Estudiante">Estudiante</option>
                        <option value="Postgrado">Postgrado</option>
                    </select>
                </div>
                </br><p>Departamento al que pertenece:</p>
                <label class="container">IngenierÌa Civil
                    <input type="radio" checked="checked" name="radio" value ="IngenierÌa Civil">
                    <span class="checkmark"></span>
                </label>
                <label class="container">Ingenier√≠a El√©ctrica
                    <input type="radio" name="radio" value ="IngenierÌaa ElÈctrica">
                    <span class="checkmark"></span>
                </label>
                <label class="container">Ingenier√≠a Industrial
                    <input type="radio" name="radio" value ="IngenierÌa Industrial">
                    <span class="checkmark"></span>
                </label>
                <label class="container">Ingenier√≠a Inform√°tica y Ciencias de la Computaci√≥n
                    <input type="radio" name="radio" value ="IngenierÌa Inform·tica y Ciencias de la ComputaciÛn">
                    <span class="checkmark"></span>
                </label>
                <label class="container">Ingenier√≠a de Materiales
                    <input type="radio" name="radio" value ="IngenierÌa de Materiales">
                    <span class="checkmark"></span>
                </label>
                <label class="container">Ingenier√≠a Mec√°nica
                    <input type="radio" name="radio" value ="IngenierÌa Mec·nica">
                    <span class="checkmark"></span>
                </label>
                <label class="container">Ingenier√≠a Metal√∫rgica
                    <input type="radio" name="radio" value ="IngenierÌa Metal˙rgica">
                    <span class="checkmark"></span>
                </label>
                <label class="container">Ingenier√≠a Qu√≠mica 
                    <input type="radio" name="radio" value ="IngenierÌa QuÌmica">
                    <span class="checkmark"></span>
                </label>
                ContraseÒa: <input type="password" name="txtPassword" /><br/><br/>

                <input type="submit" value="Enviar"/><br/><br/>
            </form>
        </div>
    </body>
</html>

