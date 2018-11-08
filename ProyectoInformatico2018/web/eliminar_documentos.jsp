<%-- 
    Document   : eliminar_documentos
    Created on : 28-10-2018, 21:36:58
    Author     : Martin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.AreadeInteres"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Documento"%>
<%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    Usuario usuario_perfil = (Usuario) request.getSession().getAttribute("usuario_perfil");
    List<AreadeInteres> areas_existentes = (ArrayList<AreadeInteres>) request.getSession().getAttribute("areas_existentes");
    List<Documento> documentos_usuario = (ArrayList<Documento>) request.getSession().getAttribute("documentos_usuario");
%>

<!DOCTYPE html>
<html>

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Documentos</title>
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
                font-size: 10px; /* Increased text to enable scrolling */
                padding: 0px 10px;
            }

            @media screen and (max-height: 450px) {
                .sidenav {padding-top: 15px;}
                .sidenav a {font-size: 18px;}
            }

            /* Change the link color on hover */
            li a:hover {
                background-color: #111;
                color: white;
            }
            .details li {
                list-style: none;
                background-color: #ededed;
            }
            li {
                margin-bottom:10px;
            }
            .tital{
                text-align:right;
            }
            .contant_i{
                color: #631e1e;
                border-bottom: 1px solid #cea7a7;
            }


        </style>

    </head>
    <body>
        <%@include file="sidebar.jsp" %>
        <div class="main">
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
