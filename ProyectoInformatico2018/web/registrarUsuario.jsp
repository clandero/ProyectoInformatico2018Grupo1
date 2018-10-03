<%-- 
    Document   : registrarUsuario
    Created on : Oct 3, 2018, 12:11:49 AM
    Author     : arken
--%>

<%@page import="Controlador.Registration" %>

<jsp:useBean id="obj" class="Modelo.Usuario"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
    Registration.save(obj);  
    out.print("You are successfully registered");  
  
%> 
