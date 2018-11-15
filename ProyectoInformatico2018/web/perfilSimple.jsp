<%-- 
    Document   : perfilSimple
    Created on : 09-11-2018, 1:32:25
    Author     : vanes
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="container">    
                <div class="jumbotron">
                    <div class="row">
                        <div class="col-6" style="margin-left:none;">
                            <div class="form-group" style="border-bottom:1px solid black">
                                <h2>Perfil</h2>
                            </div>
                            <div class="col-md-6" style="padding:0;">  
                                <ul class="details" style="padding:0;background-color: #ededed; margin-left: none; ">
                                    <li><p><span class="" style="width:100px;"></span>Nombre: <c:out value="${usuario_nombre2}"> </c:out> </p></li>
                                    <li><p><span class="" style="width:100px;"></span><c:out value="${usuario_tipo2}"></c:out> en Departamento de <c:out value="${depa_usuario2}"> </c:out></p></li>

                                            <li><p><span class="" style="width:100px;"></span>Correo: <c:out value="${usuario_correo2}"> </c:out></p></li>
                                    </ul>
                                    <ul class=" details" style="background-color: #ededed; margin-left: none;">


                                    </ul>
                                </div>
                            </div>
                            <div class="col-6" style="margin-left:none;">
                                <p>Áreas de interés</p>
                                <div class="col-md-6" style="padding:0;">
                                    <nav style="height:200px; width:100%; overflow:hidden; overflow-y:scroll;">
                                        <ul>
                                        <c:forEach items="${areas_usuario2}" var="area">
                                            <li><c:out value="${area.getTema()}"> </c:out></li>
                                            </c:forEach>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="jumbotron">
                    <div class="row">
                        <div class="form-group row">
                            <div class="col-md-12">
                                <div class="form-group" style="border-bottom:1px solid black">
                                    <h2>Trabajos y publicaciones</h2>
                                </div>
                                <c:forEach var="i" items="${documentos_usuario2}">
                                    <ul>
                                        <li>
                                            <c:out value="${i.getTitulo()}"></c:out>
                                            <a href="/build${i.getSvPath()}">
                                                <img width=30px src="resources/pdflogo">
                                            </a>
                                        </li>
                                    </ul>
                                </c:forEach>        
                            </div>
                        </div>
                    </div>
                </div>
                <div class="jumbotron">
                    <div class="row">
                        <div class="form-group row">
                            <div class="col-md-12">
                                <div class="form-group" style="border-bottom:1px solid black">
                                    <h2>Anuncios</h2>
                                </div>
                                <c:forEach var="anuncio" items="${anuncios_usuario2}">
                                    <div class="jumbotron">
                                        <h2>Título: ${anuncio.getTitulo()}</h2>
                                        <h5>Fecha: ${anuncio.getFecha()}</h5>
                                        <h5>Tema: ${anuncio.getTema()}</h5>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
