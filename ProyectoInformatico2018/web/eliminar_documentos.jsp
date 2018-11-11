<%-- 
    Document   : eliminar_documentos
    Created on : 28-10-2018, 21:36:58
    Author     : Martin
--%>

<%@page import="java.util.TreeSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.AreadeInteres"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Documento"%>
<%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    Usuario usuario_perfil = (Usuario) request.getSession().getAttribute("usuario_perfil");
    TreeSet<AreadeInteres> areas_existentes = (TreeSet<AreadeInteres>) request.getSession().getAttribute("areas_existentes");
    List<Documento> documentos_usuario = (ArrayList<Documento>) request.getSession().getAttribute("documentos_usuario");
%>

<!DOCTYPE html>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Eliminar Documentos</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
        <div class="main">
            <jsp:include page="searchbar.jsp"/>
            <div class="container">    
                <div class="jumbotron">
                    <div class="row">
                        <div class="form-group row">
                            <div class="col-md-12">
                                <div class="form-group" style="border-bottom:1px solid black">
                                    <h2>TRABAJOS/PROYECTOS</h2>
                                </div>
                                <form action="EliminarDocumento" method="post">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Eliminar?</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="i" items="${documentos_usuario}">
                                                <tr>
                                                    <td><c:out value="${i}"></c:out></td>
                                                    <td><input type="checkbox" value="${i}" name="documento"> Si</td>
                                                <tr>
                                            </c:forEach>        
                                        </tbody>
                                    </table>
                                    <input type="submit" value="Guardar cambios">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
