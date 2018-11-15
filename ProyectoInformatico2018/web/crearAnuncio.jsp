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
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>

    </head>
    <body>
        <%@include file="sidebar.jsp" %>
        <div class="main">
            <jsp:include page="searchbar.jsp"/>
            <h1>CREAR ANUNCIO</h1><br/><br/>
            <div class="jumbotron">
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
                                    <c:forEach items="${areas_existentes}" var="area">
                                        <option value="${area.getTema()}" selected><c:out value="${area.getTema()}"></c:out></option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Contenido de Anuncio:</td>
                            <td><textarea name="txtContenido" rows="10" cols="100"></textarea></td>
                        </tr>
                    </table><br/><br/>
                    <input type="submit" value="Crear"/>
                </form>
            </div>

        </div>

    </body>
</html>
