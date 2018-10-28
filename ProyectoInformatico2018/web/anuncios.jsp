<%-- 
    Document   : anuncios
    Created on : 24-10-2018, 15:13:50
    Author     : cland
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página principal</title>
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <jsp:include page="sidebar.jsp"/>
        <div class="main">
            <jsp:include page="searchbar.jsp"/>
            <div class="container">
            <h1>Hello World!</h1>
                <div class="jumbotron">
                </div>
            </div>
        </div>
    </body>
</html>
