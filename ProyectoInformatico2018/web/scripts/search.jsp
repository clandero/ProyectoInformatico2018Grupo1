<%-- 
    Document   : searchJS
    Created on : Oct 28, 2018, 12:17:45 PM
    Author     : Vicente Varas <vvaras@udec.cl>
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
<!DOCTYPE html>
<script>
    function buscarPersona(){
        document.getElementById("searchForm").action="busqueda";
        document.getElementById("op_busqueda").options.length=0;
        document.getElementById("op_busqueda").options[0]=new Option("Área de Interés", "area", true, false);
        document.getElementById("op_busqueda").options[1]=new Option("Departamento", "depto", true, false);
    }
    function buscarDocumento(){
        document.getElementById("searchForm").action="buscarTrabajo";
        document.getElementById("op_busqueda").options.length=0;
        //hay que poner los valores correctos
        document.getElementById("op_busqueda").options[0]=new Option("Titulo", "titulo", true, false);
        document.getElementById("op_busqueda").options[1]=new Option("Tema", "tema", true, false);
    }
</script>