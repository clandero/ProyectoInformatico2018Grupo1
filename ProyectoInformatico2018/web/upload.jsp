<%-- 
    Document   : upload.jsp
    Created on : Oct 4, 2018, 2:21:01 AM
    Author     : arken
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Subida de documentos</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
        <link href="css/perfil.css" rel="stylesheet" type="text/css"/>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
        <div class="main">
            <div class="card card-container">
                <form method="POST" action="upload" enctype="multipart/form-data" >
                    File:
                    <input type="file" name="file" id="file"> <br>
                    <br>
                    Correo: <input type="text" name="correo" id="file"> <br>
                    <br>
                    Tema: <input type="text" name="tema" id="file"> <br>
                    <br>
                    <input type="submit" value="Upload" name="upload" id="upload" >
                </form>
            </div>
        </div>
        
    </body>
</html>