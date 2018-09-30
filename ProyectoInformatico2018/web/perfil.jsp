<%-- 
    Document   : perfil
    Created on : 26-09-2018, 22:43:42
    Author     : vanes
--%>
<%@page import="Modelo.Usuario"%>
<%
    Usuario u1 = (Usuario)request.getSession().getAttribute("usuario1");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style>
                        body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 160px;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    padding-top: 20px;
}

.sidenav a {
    padding: 6px 8px 6px 16px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.main {
    margin-left: 160px; /* Same as the width of the sidenav */
    font-size: 10px; /* Increased text to enable scrolling */
    padding: 0px 10px;
}

@media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
    .sidenav a {font-size: 18px;}
}

/* Change the link color on hover */
            li a:hover {
                background-color: #111;
                   color: white;
            }
                .details li {
      list-style: none;
      background-color: #ededed;
    }
    li {
        margin-bottom:10px;
    }
   .tital{
       text-align:right;
   }
   .contant_i{
        color: #631e1e;
        border-bottom: 1px solid #cea7a7;
   }
 

        </style>
    </head>
    <body>
            <div class="sidenav">
            <a href="perfil.jsp">Perfil</a>
  <a href="#services">Anuncios</a>
  <a href="#clients">Contactos</a>
  <a href="#contact">Logout</a>
        </div>
        <div class="main">
            <div class="container">    
                <div class="jumbotron">
                    
                    
                    
                  <div class="row">
                      <div class="col-md-3 col-xs-12 col-sm-6 col-lg-3">
                        <div class="thumbnail text-center photo_view_postion_b" >
                          <img src="http://dkextras.com/DK/images/profile/dfe29f0b7f57ca5cb982ac9b323ac975.jpg" alt="stack photo" class="img">
                        </div>
                      </div>
                      <div class="col-md-9 col-xs-12 col-sm-6 col-lg-9">
                          <div class="" style="border-bottom:1px solid black">
                            <h2>PERFIL</h2>
                          </div>
                            <hr>
                          <div class="col-md-8">  
                              <ul class=" details" style="background-color: #ededed ">
                            <li><p><span class="" style="width:100px;"></span>Nombre: <%= u1.getNombreUsuario() %></p></li>
                            <li><p><span class="" style="width:100px;"></span>Tipo: <%= u1.getTipoUsuario() %></p></li>
                            <li><p><span class="" style="width:100px;"></span>Departamento: <%= u1.getDepartamento() %></p></li>
                            <li><p><span class="" style="width:100px;"></span>Correo: <%= u1.getCorreo() %></p></li>
                          </ul>
                          </div>
                          <div class="col-md-4">  
                            <div class="col-sm-5 col-xs-6 tital " >Intereses :</div><div class="col-sm-7 col-xs-6 ">Interes 1</div>
                            <div class="clearfix"></div><div class="bot-border"></div>
                            <div class="col-sm-5 col-xs-6 tital " >           </div><div class="col-sm-7 col-xs-6 ">Interes 2</div>
                            <div class="clearfix"></div><div class="bot-border"></div>
                            <div class="col-sm-5 col-xs-6 tital " >           </div><div class="col-sm-7 col-xs-6 ">Interes 3</div>
                            <div class="clearfix"></div><div class="bot-border"></div>
                          </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="form-group row">
                        <div class="col-md-12">
                        <div class="form-group" style="border-bottom:1px solid black">
                            <h2>TRABAJOS/PROYECTOS</h2>
                        </div>
                        </div>
                      </div>
                    </div>
                    <div class="row"> 
                     <div class="col-md-4">
                        <div class="col-sm-6 col-xs-6 tital " >Height(feet):</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                        <div class="col-sm-6 col-xs-6 tital " >Weight(lbs):</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                        <div class="col-sm-6 col-xs-6 tital " >Hair Color:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                        <div class="col-sm-6 col-xs-6 tital " >Hair Length:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                        <div class="col-sm-6 col-xs-6 tital " >Suit/Dress:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                     </div>
                     <div class="col-md-4">
                        <div class="col-sm-6 col-xs-6 tital " >Shirt Size:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                        <div class="col-sm-6 col-xs-6 tital " >Shoe Size:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                        <div class="col-sm-6 col-xs-6 tital " >Bust:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                        <div class="col-sm-6 col-xs-6 tital " >Waist:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                        <div class="col-sm-6 col-xs-6 tital " >Inseam:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                     </div>
                     <div class="col-md-4">
                        <div class="col-sm-6 col-xs-6 tital " >Hips:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                        <div class="col-sm-6 col-xs-6 tital " >Glove:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                        <div class="col-sm-6 col-xs-6 tital " >Hat:</div><div class="col-sm-6 col-xs-6 contant_i">Prasad</div>
                        <div class="clearfix"></div><div class="bot-border"></div>
                     </div>
                    </div>
                    
                    <div class="row">
                      <div class="form-group row">
                        <div class="col-md-12">
                            <div class="form-group" style="border-bottom:1px solid black">
                                <h2>EXPERIENCIA</h2>
                            </div>
                            <div class="col-md-6">
                                <div class="col-sm-4 col-xs-6 tital " >Brand:</div><div class="col-sm-8 col-xs-6 contant_i">Prasad</div>
                                <div class="clearfix"></div><div class="bot-border"></div>
                                <div class="col-sm-4 col-xs-6 tital " >Year:</div><div class="col-sm-8 col-xs-6 contant_i">Prasad</div>
                                <div class="clearfix"></div><div class="bot-border"></div>
                             </div>    
                           <div class="col-md-6">
                                <div class="col-sm-4 col-xs-6 tital " >Model:</div><div class="col-sm-8 col-xs-6 contant_i">Prasad</div>
                                <div class="clearfix"></div><div class="bot-border"></div>
                                <div class="col-sm-4 col-xs-6 tital " >Color:</div><div class="col-sm-8 col-xs-6 contant_i">Prasad</div>
                                <div class="clearfix"></div><div class="bot-border"></div>
                             </div>    
                            
                        </div>
                      </div>
                    </div>
                    
                    
                    
                    
                    
                    
                </div>
            </div>
        </div>
    </body>
</html>