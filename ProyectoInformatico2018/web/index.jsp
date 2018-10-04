<%-- 
    Document   : index
    Created on : 27-09-2018, 16:30:14
    Author     : cland
--%>

<%@page import="java.sql.Connection"%>
<%@page import="Controlador.DatabaseConnect"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/cssIndex.css" type="text/css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" type="text/css">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body class="w3-main">
        <div class="w3-sidebar w3-bar-block w3-grey" style="width:15%">
            <a href="#" class="w3-bar-item w3-button"><img src="imagenes/escudo.gif" alt="" style="width: 50px" class="center"/></a>
            <a href="#" class="w3-bar-item w3-button w3-hover-black">Mi Perfil</a>
            <a href="#" class="w3-bar-item w3-button w3-hover-black">Link 3</a>
            <a href="#" class="w3-bar-item w3-button w3-hover-black">Link 4</a>
            <a href="#" class="w3-bar-item w3-button w3-hover-black">Link 5</a>
        </div>
        
        <div class= "w3-container" style="margin-left:15%; height: 100vh; background-image: url('imagenes/edificio_fi.png'); background-size:100%;  background-repeat: no-repeat;">
            <h1>Plataforma Colaborativa FI UdeC</h1>
            <form action="busqueda" method="post" >
                <h3>Busqueda de personas:
                    <input type="text" placeholder="Search.." name="Buscar">
                    
                    <select name="opcion">
                        <option value="area">Área de Interés</option>
                        <option value="depto">Departamento</option>
                    </select>
                    <input type="submit" name="Enviar"/>
                </h3>
            </form>
        </div>
       
    </body>
</html>
