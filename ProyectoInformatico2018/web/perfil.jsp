<%-- 
    Document   : perfil
    Created on : 26-09-2018, 22:43:42
    Author     : vanes
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
        <link href="css/perfil.css" rel="stylesheet" type="text/css"/>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <title>Perfil</title>
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
                                <h2>Mi Perfil</h2>
                            </div>
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
                                <p>?reas de inter?s</p>
                                <div class="col-md-6" style="padding:0;">
                                    <nav style="height:200px; width:100%; overflow:hidden; overflow-y:scroll;">
                                        <ul>
                                        <c:forEach items="${areas_usuario}" var="area">
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
                                    <h2>Mis trabajos y publicaciones</h2>
                                </div>
                                <c:forEach var="i" items="${documentos_usuario}">
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
                                    <h2>Mis anuncios</h2>
                                </div>
                                <c:forEach var="anuncio" items="${anuncios_usuario}">
                                    <div class="jumbotron">
                                        <h2>T?tulo: ${anuncio.getTitulo()}</h2>
                                        <h5>Fecha: ${anuncio.getFecha()}</h5>
                                        <h5>Tema: ${anuncio.getTema()}</h5>
                                        <c:if test="${usuario.getCorreo().equals(usuario_perfil.getCorreo())}">

                                            <form action="editar_anuncio" method="get">
                                                <button type="submit" name="anuncio" value="${anuncio.getNumero()}">
                                                    Editar Anuncio
                                                </button>
                                            </form>
                                            <form action="editar_anuncio" method="post">
                                                <button type="submit" name="borrar_anuncio" value="${anuncio.getNumero()}">
                                                    Borrar Anuncio
                                                </button>
                                            </form>
                                        </c:if>
                                    </div>
                                </c:forEach>
                                <c:if test="${usuario.getCorreo().equals(usuario_perfil.getCorreo())}">
                                    <button id="editButton" class="float-left submit-button" >Editar Perfil</button>

                                    <script type="text/javascript">
                                        document.getElementById("editButton").onclick = function () {
                                            location.href = "editar_perfil.jsp";
                                        };
                                    </script>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
