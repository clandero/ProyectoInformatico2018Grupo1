<%-- 
    Document   : personas
    Created on : 06-11-2018, 21:32:22
    Author     : vanes
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
        <div class="main">
            <jsp:include page="searchbar.jsp"/>
            <h1>PERSONAS</h1><br/><br/>
            <div class="container">
                <c:if test="${personasInteresComun.isEmpty()}">
                    Ingrese intereses para buscar personas.
                </c:if>
            
            <c:forEach items="${personasInteresComun}" var="pic">
                <form method="post" action="personas">
                <div class="jumbotron">
                    <h2>${pic.getNombreUsuario()}</h2>
                    <input type="hidden" name="person" value="${pic.getCorreo()}">
                    <p>${pic.getTipoUsuario()} ${depad.get_nombre(Integer.toString(pic.getDepartamento()))}</p>
                    <p>${pic.getCorreo()}</p>
                    <c:forEach items="${pic.getIntereses()}" var="in">
                        <p>${in.getTema()}</p>
                    </c:forEach>
                    <input type="submit" value="Ver Perfil"/><br/><br/>
                </div>
                </form>
            </c:forEach>
            

          
            </div>         
        </div>

    </body>
</html>
