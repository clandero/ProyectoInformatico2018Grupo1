<%-- 
    Editar Perfil
    Document   : editar
    Created on : Oct 2, 2018, 1:50:59 PM
    Author     : alexis
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Hay que verificar que es el usuario que esta autentificado el que edita su propio perfil!--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Editar Perfil</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
        <div class="main">
            <jsp:include page="searchbar.jsp"/>
            <div class="container">    
                <div class="jumbotron">
                    <div class="row">
                        <div class="" style="border-bottom:1px solid black">
                                <h2>Mi Perfil</h2>
                        </div>
                        <div class="col-6">
                            <div class="col-md-6" style="padding:0;">  
                                <ul class="details" style="padding:0;background-color: #ededed; margin-left: none; ">
                                    <li><p><span class="" style="width:100px;"></span>Nombre: <c:out value="${usuario_nombre}"> </c:out> </p></li>
                                    <li><p><span class="" style="width:100px;"></span><c:out value="${usuario_tipo}"></c:out> en Departamento de <c:out value="${depa_usuario}"> </c:out></p></li>
                                    
                                    <li><p><span class="" style="width:100px;"></span>Correo: <c:out value="${usuario_correo}"> </c:out></p></li>
                                </ul>
                                <ul class=" details" style="background-color: #ededed; margin-left: none;">
                                    

                                </ul>
                            </div>
                        </div>
                        <div class="col-6" style="margin-left:none;">
                            <p>Áreas de interés</p>
                            <div class="col-md-6" style="padding:0;">
                                <form action="EditarPerfil" method="post">
                                    <nav style="height:200px; width:100%; overflow:hidden; overflow-y:scroll;">
                                        <c:forEach items="${areas_existentes}" var="area">
                                            <div class="col-sm-7 col-xs-6 ">
                                                <input type="checkbox" value="${area.getTema()}" name="interes" size="10"> ${area.getTema()}                             
                                            </div>
                                        </c:forEach>
                                    </nav>
                                    <br>
                                    <input type="submit" value="Guardar cambios">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="jumbotron">
                    <div class="row">
                        <div class="form-group row">
                            <div class="col-md-12">
                                <div class="form-group" style="border-bottom:1px solid black">
                                    <h2>Mis trabajos y publicaciones</h2>
                                    <c:forEach var="i" items="${documentos_usuario}">
                                    <ul>
                                        <li>
                                            <c:out value="${i.getTitulo()}"></c:out>
                                            <a href="/build/${i.getSvPath()}">
                                                <img width=30px src="resources/pdflogo" }">
                                            </a>
                                            <a href="/build/deleteFile?fileID=${i.getID()}">
                                                <img width=30px src="resources/trashcan" }">
                                            </a>
                                        </li>
                                    </ul>
                                </c:forEach> 
                                </div>
                            </div>
                        </div>
                    </div>         
                </div>
                <div class="jumbotron">
                    <div class="row">
                        <div class="form-group row">
                            <div class="col-md-12">
                                <div class="form-group" style="border-bottom:1px solid black">
                                    <h2>Mis anuncios</h2>
                                </div> 
                            </div>
                        </div>
                    </div>          
                </div>
            </div>
        </div>
    </body>
</html>
