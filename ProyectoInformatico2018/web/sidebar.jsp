<%-- 
    Document   : sidebar
    Created on : Oct 15, 2018, 11:54:31 PM
    Author     : Vicente Varas <vvaras@udec.cl>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="sidenav">
    <a href="perfil.jsp">Perfil</a>
    <a href="upload.jsp">Subir Doc.</a>
    <a href="#">Anuncios</a>
    <form name="forma" method="post" action="areas">
        <a onclick="forma.submit()" href="#">Crear Anuncio</a>
    </form>
    <a href="#clients">Contactos</a>
    <a href="#contact">Logout</a>
</div>

