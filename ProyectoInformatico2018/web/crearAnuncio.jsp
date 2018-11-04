<%-- 
    Document   : perfil
    Created on : 26-09-2018, 22:43:42
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
                font-size: 20px; /* Increased text to enable scrolling */
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
            .table, th, td {
                border: 1px solid black;
                font-size: 20px;
            }
            
            .sinborde {
                font-size: 20px;
            }

        </style>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
        <div class="main">
            <h1>CREAR ANUNCIO</h1><br/><br/>
            <form method="post" action="crear_Anuncio">
                <table>
                    <tr>
                        <td>Título:</td>
                        <td><input class="sinborde" size="100" type="text" name="txtTitulo" required /></td>
                    </tr>
                    <tr>
                        <td>Área de interes:</td>
                        <td>
                            <select name="txtArea">
                                <c:forEach items="${areas}" var="area">
                                    <option value="${area}" selected><c:out value="${area}"></c:out></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Contenido de Anuncio:</td>
                        <td><textarea name="txtContenido" rows="10" cols="100"></textarea></td>
                    </tr>
                </table><br/><br/>
                <input type="submit" value="Crear"/><br/><br/>
            </form>
            
        </div>

    </body>
</html>
