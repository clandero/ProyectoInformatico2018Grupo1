<%-- 
    Document   : searchbar
    Created on : 25-10-2018, 16:15:21
    Author     : cland
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <form style="margin:15px;" action="busqueda" method="post" >
        <h3>
            <input type="text" placeholder="Buscar.." name="Buscar">

            <select name="opcion">
                <option value="area">Área de Interés</option>
                <option value="depto">Departamento</option>
            </select>
            <input type="submit" name="Enviar"/>
        </h3>
    </form>
