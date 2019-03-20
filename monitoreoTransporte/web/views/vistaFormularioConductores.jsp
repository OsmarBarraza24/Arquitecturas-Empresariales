<%-- 
    Document   : vistaFormularioConductores
    Created on : 12-mar-2019, 19:30:14
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
    <title>Formulario Conductores</title>
</head>
<body>
<div class="container">
    <form>
        <div class="form-group">
            <h1>Agregar condutor</h1>
            
          <label for="nombreCompleto">Nombre completo : </label>
          <input type="text" class="form-control" id="nombreCompleto" aria-describedby="emailHelp" placeholder="Nombre del Conductor">
        </div>
        <div class="form-group">
          <label for="Descripcion">Descripcion :</label>
          <input type="textarea" class="form-control" id="descripcion" placeholder="Descripcion">
        </div>

        <div class="form-group">
          <label for="Descripcion">IFE :</label>
          <input type="text" class="form-control" id="ife" placeholder="IFE del conductor">
        </div>
        <div class="form-group">
          <label for="Descripcion">CURP :</label>
          <input type="text" class="form-control" id="curp" placeholder="CURP">
        </div>

        <div class="form-group">
          <label for="Descripcion">RFC :</label>
          <input type="text" class="form-control" id="rfc" placeholder="RFC">
        </div>

        <div class="form-group">
          <label for="Descripcion">Licencia :</label>
          <input type="textarea" class="form-control" id="licencia" placeholder="Licencia">
        </div>
       
       <div class="form-group">
          <label for="Descripcion">Vigencia de la Licencia :</label>
          <input type="date" class="form-control" id="vigenciaLicencia" placeholder="vigencia">
        </div>

        <div class="form-group">
          <label for="Descripcion">Teléfono :</label>
          <input type="textarea" class="form-control" id="telefono" placeholder="Teléfono">
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