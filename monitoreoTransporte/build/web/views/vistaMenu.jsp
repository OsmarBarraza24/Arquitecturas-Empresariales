<%--
    Document   : vistaMenu
    Created on : 19/03/2019, 06:10:57 PM
    Author     : mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="../css/bootstrap.css">
          <link rel="stylesheet" href="../css/styles.css">
          <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
          <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <title>Menu</title>
    </head>
    <body>

      <div class="mainWrapper">
            <!-- Contenedor del Navbar-->
            <ul>
                <li id="logo">NombreEmpresa</li>
                <li><a href="../index.jsp">Inicio</a></li>
                <li><a href="#">Menu</a></li>
                <li><a href="#">Configuración</a></li>
                <li><a href="#">Salir</a></li>
            </ul>
        </div>
      <!-- Image and text -->
      <!--
      <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="#">
          <img src="/docs/4.3/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
          NombreEmpresa
        </a>
      </nav>
-->
<div class="container">
<div class="card-columns">
      <div class="card" style="width: 13rem; height:13rem;">
    <img src="../img/Driver_100px.png" class="card-img-top" alt="...">
          <div class="card-body">
            <br><br>
        <a href="views/vistaConductores" style="font-family: 'Roboto', sans-serif;" class="stretched-link">Conductores</a>
            </div>
</div>
      <div class="card" style="width: 13rem; height:13rem;">
      <img src="../img/GPS_100px.png" class="card-img-top" alt="...">
        <div class="card-body">
            <br><br>
          <a href="views/vistaGps" style="font-family: 'Roboto', sans-serif;"class="stretched-link">GPS</a>
          </div>
</div>
      <div class="card" style="width: 13rem; height:13rem;">
        <img src="../img/LineaTransportista_100px.png" class="card-img-top" alt="...">
          <div class="card-body">
              <br><br>
            <a href="views/vistaLineaTransportista"style="font-family: 'Roboto', sans-serif;" class="stretched-link">Linea Transportista</a>
            </div>
</div>
</div>
<div class="card-columns">
<div class="card" style="width: 13rem; height:13rem;">
  <img src="../img/PerfilUsuario_100px.png" class="card-img-top" alt="...">
    <div class="card-body">
        <br><br>
      <a href="views/vistaPerfilUsuario" style="font-family: 'Roboto', sans-serif;" class="stretched-link">Perfil de Usuario</a>
      </div>
</div>
<div class="card" style="width: 13rem; height:13rem;">
  <img src="../img/Bus_100px.png" class="card-img-top" alt="...">
    <div class="card-body">
        <br><br>
      <a href="views/vistaPuntoCaptura" style="font-family: 'Roboto', sans-serif;" class="stretched-link">Punto de captura</a>
      </div>
</div>
<div class="card" style="width: 13rem; height:13rem;">
  <img src="../img/Transporte_100px.png" class="card-img-top" alt="...">
    <div class="card-body">
        <br><br>
      <a href="views/vistaTransporte" style="font-family: 'Roboto', sans-serif;" class="stretched-link">Transportes</a>
      </div>
</div>
</div>
<div class="card-columns">
<div class="card" style="width: 13rem; height:13rem;">
  <img src="../img/User_100px.png" class="card-img-top" alt="...">
    <div class="card-body">
        <br><br>
      <a href="views/vistaConductores" style="font-family: 'Roboto', sans-serif;" class="">Usuarios</a>
      </div>
</div>


      </div>
</div>




      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
