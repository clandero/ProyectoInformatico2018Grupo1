<%-- 
    Document   : upload.jsp
    Created on : Oct 4, 2018, 2:21:01 AM
    Author     : arken
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>

<!DOCTYPE html>
<html>
    <head>
        <title>File Upload</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script> function other(){
                    var checkbox = document.getElementById("check");
                    if (checkbox.checked){
                        document.getElementById("select")
                                .setAttribute("style", "display: none;");
                        document.getElementById("otro")
                                .setAttribute("style", "display: inline; max-width: 150px");
                    } else{
                        document.getElementById("select")
                                .setAttribute("style", "display: inline;");
                        var otro = document.getElementById("otro");
                        otro.setAttribute("style", "display: none;");                        
                        otro.value = "";
                    }
                }
        </script>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
        <c:if test="${success=='true'}">
            <div class=" card card-container">
                El archivo se ha guardado correctamente.
            </div>
        </c:if>
        <c:if test="${success=='false'}">
            <div class=" card card-container">
                Ha ocurrido un error al guardar el archivo:
                "${message}"
            </div>
        </c:if>
        <div class=" card card-container">
            <form method="POST" action="upload" enctype="multipart/form-data" >
                File:
                <input type="file" name="file" id="file"> <br>
                <br>
                <!-- Tema: <input type="text" name="tema" id="file"> <br> -->
                Tema: <select id="select" name="tema" style="display: inline;"">
                     <c:forEach var="i" items="${temas}">
                        <option value=${i.getTema()}>${i.getTema()}</option>
                    </c:forEach>                
                </select> 
                <input type="text" name="otro" placeholder="Tema" id="otro" style="display: none;">
                <input type="checkbox" name="checkotro" id="check" onclick="other()"> Otro                
                <br>                
                <input type="submit" value="Upload" name="upload" id="upload" >
            </form>
        </div>
    </body>
</html>