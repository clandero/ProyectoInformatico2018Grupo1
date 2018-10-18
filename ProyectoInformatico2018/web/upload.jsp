<%-- 
    Document   : upload.jsp
    Created on : Oct 4, 2018, 2:21:01 AM
    Author     : arken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>File Upload</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
        <div class=" card card-container">
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
    </body>
</html>