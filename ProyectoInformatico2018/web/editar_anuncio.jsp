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
        <title>Editar Anuncio</title>
    </head>
    <body>
        <jsp:include page="sidebar.jsp"/>
        <div class="main">
            <jsp:include page="searchbar.jsp"/>
            <h1>Editar ANUNCIO</h1><br/><br/>
            <form method="post" action="editar_anuncio">
                <table>
                    <tr>
                        <td>Título:</td>
                        <td>
                            <input class="sinborde" size="100" type="text" name="titulo_anuncio" value="${anuncio_editar.getTitulo()}"required />
                        </td>
                    </tr>
                    <tr>
                        <td>Área de interes:</td>
                        <td>
                            <select name="area_anuncio" >
                                <c:forEach items="${areas_existentes}" var="area">
                                    <option value="${area.getTema()}" ${(area.getTema()== anuncio_editar.getTema())?'selected' : ' '}>
                                        <c:out value="${area.getTema()}"></c:out></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Contenido de Anuncio:</td>
                        <td>
                            <textarea name="contenido_anuncio" rows="10" cols="100"><c:out value="${anuncio_editar.getContent()}"></c:out></textarea>
                        </td>
                    </tr>
                </table><br/><br/>
                <input type="submit" value="Guardar"/><br/><br/>
            </form>
            
        </div>

    </body>
</html>
