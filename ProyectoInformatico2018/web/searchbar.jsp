<%-- 
    Document   : searchBar
    Created on : Oct 28, 2018, 10:54:53 AM
    Author     : Vicente Varas <vvaras@udec.cl>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="searchJS.jsp"/>
<form action="busqueda" method="post" id="searchForm">
    <h3>
        <input type="text" placeholder="Buscar.." name="Buscar">

        <select name="opcion" id="op_busqueda">
            <option value="area" >Área de Interés</option>
            <option value="depto">Departamento</option>
        </select>
        
        <input type="submit" name="Enviar" value="Buscar"/><br>
        <input type="radio" name="searchSelect" onclick="buscarPersona();" checked> Buscar Persona
        <input type="radio" name="searchSelect" onclick="buscarDocumento();" > Buscar Trabajo
    </h3>
</form>