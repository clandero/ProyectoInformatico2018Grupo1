<%-- 
    Document   : resultadosBusqueda
    Created on : 28-09-2018, 15:22:09
    Author     : cland
--%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.ArrayList"%>
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
            <a href="perfil.jsp" class="w3-bar-item w3-button w3-hover-black">Mi Perfil</a>
        </div>
        <div class= "w3-container" style="margin-left:15%; height: 100vh; background-image: url('imagenes/edificio_fi.png'); background-size:100%;  background-repeat: no-repeat;">
        <%String x = (String)request.getSession().getAttribute("Buscar");
        String q = request.getParameter("opcion");%>
        <h1>Resultados de búsqueda: <%= x%></h1>
        <%if(q.equals("area")){%>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Correo</th>
                </tr>
            </thead>
            <tbody>
                <%Hashtable<String, ArrayList<String>> res = (Hashtable<String, ArrayList<String>>)request.getSession().getAttribute("resultados");
                for (Entry<String, ArrayList<String>> entry : res.entrySet()) {
                    ArrayList<String> aux = entry.getValue();
                    String correo = aux.get(0);%>
                    <tr>
                        <td><%= entry.getKey() %></td>
                        <td><%= correo %></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
        <%}%>
        <%if(q.equals("depto")){%>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Área de interés</th>
                </tr>
            </thead>
            <tbody>
                <%Hashtable<String, ArrayList<String>> res = (Hashtable<String, ArrayList<String>>)request.getSession().getAttribute("resultados"); 
                for (Entry<String, ArrayList<String>> entry : res.entrySet()) {
                    ArrayList<String> aux = entry.getValue();
                    String correo = aux.get(0);
                    String tema = aux.get(1);%>
                    <tr>
                        <td><%= entry.getKey() %></td>
                        <td><%= correo %></td>
                        <%if(aux.size() > 2){
                            for(int i=2;i<aux.size();i++){ tema = tema + " / " + aux.get(i);}}%>
                        <td><%= tema %></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
        <%}%>
        </div>
    </body>
</html>
