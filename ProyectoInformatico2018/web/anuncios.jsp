<%-- 
    Document   : anuncios
    Created on : 24-10-2018, 15:13:50
    Author     : cland
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página principal</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <jsp:include page="sidebar.jsp"/>
        <div class="main">
            <jsp:include page="searchbar.jsp"/>
            <div class="container">
            <c:forEach var="i" items="${lista_anuncios}">
                <div class="jumbotron">
                    <h2>Título: ${i.getTitulo()}</h2>
                    <p>${i.getContent()}</p>
                    <p>Escrito por: ${i.getUsuario()}</p>
                    <h5>Tema: ${i.getTema()}</h5>
                    <h5>Fecha: ${i.getFecha()}</h5>
                </div>
            </c:forEach>
            </div>
        </div>
    </body>
</html>
