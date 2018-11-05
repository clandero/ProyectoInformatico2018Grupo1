<%-- 
    Document   : perfil
    Created on : 26-09-2018, 22:43:42
    Author     : vanes
--%>
<%@page import="java.util.TreeSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.AreadeInteres"%>
<%@page import="Modelo.Usuario"%>
<%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    Usuario usuario_perfil = (Usuario) request.getSession().getAttribute("usuario_perfil");
    TreeSet<AreadeInteres> areas_existentes = (TreeSet<AreadeInteres>) request.getSession().getAttribute("areas_existentes");
    TreeSet<AreadeInteres> areas_usuario = (TreeSet<AreadeInteres>) request.getSession().getAttribute("areas_usuario");

%>
<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
<!DOCTYPE html>
<html>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <head>
        
        <title>Perfil</title>
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
        <jsp:include page="sidebar.jsp"/>
        <div class="main">    
            <jsp:include page="searchbar.jsp"/>
            <div class="container">    
                <div class="jumbotron">
                    <div class="row">
                        <div class="col-md-3 col-xs-12 col-sm-6 col-lg-3">
                            <div class="thumbnail text-center photo_view_postion_b" >
                                <img src="http://dkextras.com/DK/images/profile/dfe29f0b7f57ca5cb982ac9b323ac975.jpg" alt="stack photo" class="img">
                            </div>
                        </div>
                        <div class="col-md-9 col-xs-12 col-sm-6 col-lg-9">
                            <div class="" style="border-bottom:1px solid black">
                                <h2>Mi Perfil</h2>
                            </div>
                            <hr>
                            <div class="col-md-6" style="padding:0;">  
                                <ul class="details" style="padding:0;background-color: #ededed; margin-left: none; ">
                                    <li><p><span class="" style="width:100px;"></span>Nombre: <%= usuario_perfil.getNombreUsuario()%></p></li>
                                    <li><p><span class="" style="width:100px;"></span>Tipo: <%= usuario_perfil.getTipoUsuario()%></p></li>
                                    <li><p><span class="" style="width:100px;"></span>Departamento: <%= usuario_perfil.getDepartamento()%></p></li>
                                    <li><p><span class="" style="width:100px;"></span>Correo: <%= usuario_perfil.getCorreo()%></p></li>
                                </ul>
                            </div>
                            <!-- Iterate and display actual interests of user -->
                            <div class="col-md-6" style="margin-left:none;">  
                                <div class="col-sm-5 col-xs-6 tital " >Intereses : </div>
                                <c:forEach items="${areas_usuario}" var="area">
                                    <div class="col-sm-7 col-xs-6 ">
                                        <c:out value="${area.getTema()}"> </c:out>                
                                        </div>
                                        <div class="clearfix"></div>
                                        <div class="bot-border"></div>
                                        <div class="col-sm-5 col-xs-6 tital " ></div>                  
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group row">
                            <div class="col-md-12">
                                <div class="form-group" style="border-bottom:1px solid black">
                                    <h2>TRABAJOS/PROYECTOS</h2>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group row">
                            <div class="col-md-12">
                                <div class="form-group" style="border-bottom:1px solid black">
                                    <h2>EXPERIENCIA</h2>
                                </div>

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
