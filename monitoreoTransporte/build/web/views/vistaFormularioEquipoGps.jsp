<%-- 
    Document   : vistaFormularioConductores
    Created on : 12-mar-2019, 19:23:11
    Author     : EduardoHumberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Gps</title>
</head>
<body>
<div class="container">
    <form>
        <div class="form-group">
            <h1>Equipo de rastreo GPS</h1>
            
          <label for="nombreCompleto">Nombre completo : </label>
          <input type="text" class="form-control" id="nombreCompleto" aria-describedby="emailHelp" placeholder="Nombre completo">
        </div>
        <div class="form-group">
          <label for="Descripcion">Marca :</label>
          <input type="textarea" class="form-control" id="marca" placeholder="Marca">
        </div>

        <div class="form-group">
          <label for="Descripcion">Modelo :</label>
          <input type="text" class="form-control" id="modelo" placeholder="Modelo">
        </div>
        <div class="form-group">
          <label for="Descripcion">Número de serie :</label>
          <input type="text" class="form-control" id="numeroSerie" placeholder="Número de serie">
        </div>

        <div class="form-group">
          <label for="Descripcion">imeiGPS :</label>
          <input type="text" class="form-control" id="imeiGPS" placeholder="imeiGPS">
        </div>

        <div class="form-group">
          <label for="Descripcion">Chip de teléfono :</label>
          <input type="textarea" class="form-control" id="chipTelefono" placeholder="Chip de Teléfono">
        </div>
       
       <div class="form-group">
          <label for="Descripcion">imeiChip :</label>
          <input type="text" class="form-control" id="imeiChip" placeholder="imeiChip">
        </div>

        <div class="form-group">
          <label for="Descripcion">Dígito de seguridad :</label>
          <input type="textarea" class="form-control" id="digitoSeguridad" placeholder="Dígito de seguridad">
        </div>

        <div class="form-group">

        <button type="cancel" class="btn btn-primary">Cancelar</button>
       
      

        <button type="submit" class="btn btn-primary">Agregar</button>
        </div>
      </form>

</div>
        
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>    
</body>
</html>
