<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <%
      String saludo = (String)request.getAttribute("saludo");
    %>
    <h1>Ingrese una nueva mascota</h1>
    <h3><%=saludo %></h3>
    <form action="/Sesiones/NuevaMascota" method="post">
      <div>
        <label>Nombre:</label>
        <input required name="nombre">
      </div>
      <div>
        <label>Especie:</label>
        <select name="especie">
          <option value="perro">Perro</option>
          <option value="gato">Gato</option>
          <option value="conejo">Conejo</option>
        </select>
      </div>
      <div>
        <label>Edad:</label>
        <input required name="edad" type="number">
      </div>
      <div>
        <input type="submit">
      </div>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>