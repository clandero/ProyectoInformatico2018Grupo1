<%-- 
    Document   : resultadosBusqueda
    Created on : 28-09-2018, 15:22:09
    Author     : cland
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
        <link href="css/perfil.css" rel="stylesheet" type="text/css"/>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <title>Resultados de la búsqueda</title>
    </head>
    <body>
        <jsp:include page="sidebar.jsp"/>
        <div class="main">
            <jsp:include page="searchbar.jsp"/>
            <div class="container">
                <div class="jumbotron">
                    <div class="row">
                        <div class="col-6" style="margin-left:none;">
                            <div class="form-group" style="border-bottom:1px solid black">
                                    <h2>Resultados de búsqueda: ${Buscar}</h2>
                            </div>
                           
                            <c:if test="${opcion=='area'}">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                            <th></th>
                                            <th>Correo</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="i" items="${resultados}">
                                            <tr>
                                                <td>${i.getNombreUsuario()}</td>
                                                <td></td>
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
                                                
                                                <td><c:forEach var="j" items="${i.getIntereses()}" varStatus="loop">
                                                    ${j.getTema()}<c:if test="${!loop.last}">,</c:if>
                                                </c:forEach></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
