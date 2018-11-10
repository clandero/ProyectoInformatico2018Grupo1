<%-- 
    Document   : registro.jsp
    Created on : 27-09-2018, 0:00:22
    Author     : vanes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Registro</title>
    </head>
    <body>
        <div class="main">
            <div class="sidenav">
                <a href="ingreso.jsp">Ingresar</a>
                <a href="index">Registrarse</a>
            </div>
            
            
            <div class="card card-container"> <!-- Algo así funcionó en algun momento, no se que paso-->
            <h1>Registro</h1>
            <form method="post" action="registrar">
                <p>Por favor, llene los siguientes campos: </p><br />
                <p>Nombre: <input type="text" name="txtNombre" required /></p>
                <p>Correo UdeC: <input type="text" name="txtCorreo" required /></p>
                Tipo de usuario: 
                <div class="select">
                    <select name="search_categories" id="search_categories">
                        <option value="Docente" selected="selected">Docente</option>
                        <option value="Estudiante">Estudiante</option>
                        <option value="Postgrado">Postgrado</option>
                    </select>
                </div>
                </br><p>Departamento al que pertenece:</p><p></p>
                <c:forEach items="${depar}" var="nom_depa">
                <label class="container"><c:out value="${nom_depa}"> </c:out> 
                    <input type="radio" checked="checked" name="radio" value ="${nom_depa}">
                    <span class="checkmark"></span>
                </label>
                </c:forEach>
                
                Contraseña: <input type="password" name="txtPassword" required /><br/><br/>

                <input type="submit" value="Enviar"/><br/><br/>
            </form>
        </div>
        </div>
    </body>
</html>

