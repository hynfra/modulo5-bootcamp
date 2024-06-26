<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
    <!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Nuevo JSP con bootstrap</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
   <form action="/Calculadora/Calculadora" method="post">
        <div class="form-row row">

          <div class="col-3">
            <input type="text" class="form-control" placeholder="numero1" name="numero1">
          </div>
          <div class="col-3">
            <select class="form-select" aria-label="Default select example" name="operador">
                <option selected>elige una operacion</option>
                <option value="suma">+</option>
                <option value="resta">-</option>
                <option value="multiplicacion">*</option>
                <option value="division">/</option>
              </select>
          </div>
          <div class="col-3">
            <input type="text" class="form-control" placeholder="numero2" name="numero2">
          </div>
          <div class="col-3">
            <button type="submit" class="btn btn-primary" placeholder="calcular"  >calcular </button>
          </div>
          <div class="col-6">
            <label for="resultado">resultado</label>
            <input type="text" class="form-control disabled" placeholder="resultado" name="resultado">
          </div>

          <div class="col-4 offset-4">
            <ul class="list-group">
                <li class="list-group-item">Cras justo odio</li>
                <li class="list-group-item">Dapibus ac facilisis in</li>
                <li class="list-group-item">Morbi leo risus</li>
                <li class="list-group-item">Porta ac consectetur ac</li>
                <li class="list-group-item">Vestibulum at eros</li>
              </ul>
          </div>
        </div>
        
      
      </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>