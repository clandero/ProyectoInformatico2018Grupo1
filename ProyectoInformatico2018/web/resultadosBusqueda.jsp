<%-- 
    Document   : resultadosBusqueda
    Created on : 28-09-2018, 15:22:09
    Author     : cland
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/cssIndex.css" type="text/css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" type="text/css">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body class="w3-main">
        <div class="w3-sidebar w3-bar-block w3-grey" style="width:15%">
            <a href="#" class="w3-bar-item w3-button"><img src="imagenes/escudo.gif" alt="" style="width: 50px" class="center"/></a>
            <a href="perfil.jsp" class="w3-bar-item w3-button w3-hover-black">Mi Perfil</a>
        </div>
        <div class= "w3-container" style="margin-left:15%; height: 100vh; background-image: url('imagenes/edificio_fi.png'); background-size:100%;  background-repeat: no-repeat;">
        <h1>Resultados de búsqueda: ${Buscar}</h1>
        <c:if test="${opcion=='area'}">
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Correo</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" items="${resultados}">
                        <tr>
                            <td>${i.getNombreUsuario()}</td>
                            <td>${i.getCorreo()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${opcion=='depto'}">
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Correo</th>
                        <th>Área de interés</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" items="${resultados}">
                        <tr>
                            <td>${i.getNombreUsuario()}</td>
                            <td>${i.getCorreo()}</td>
                            <c:forEach var="j" items="${i.getIntereses()}">
                                <td>${j.getTema()}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        </div>
    </body>
</html>
