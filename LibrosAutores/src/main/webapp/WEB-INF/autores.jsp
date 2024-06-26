<%@page import="java.util.ArrayList"%>
<%@page import="models.Autor"%>
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
  <% ArrayList<Autor> autores =(ArrayList<Autor>) request.getAttribute("autores"); %>
    <div class="container">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="#">LibrosAutores</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="http://localhost:8080/LibrosAutores/Libros">Libros</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="http://localhost:8080/LibrosAutores/Autores">Autores</a>
		      </li>
		      
		    </ul>
		  </div>
	</nav>
		<div class="row">
		
			<div class="col-md-6">
			<h1>Agregar un autor</h1>
				<form  action="/LibrosAutores/Autores" method="post">
					<div class="form-group">
						<label for="nombre">Nombre</label> <input
							type="text" class="form-control" id="nombre" name="nombre"
							aria-describedby="emailHelp" placeholder="Ingresa el nombre del autor" required>
					</div>
					<div class="form-group">
						<label for="apellido">Apellido</label> <input
							type="text" class="form-control" id="apellido" name="apellido"
							aria-describedby="emailHelp" placeholder="Ingresa el apellido del autor" required>
					</div>
					<div class="form-group">
						<label for="notas">Notas</label> 
						<textarea class="form-control" id="notas" name="notas"  rows="3" required></textarea>
					</div>
					
					<button type="submit" class="btn btn-primary">Agregar</button>
				</form>

			</div>
			<div class="col-md-6">

				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col"> nombre </th>
							<th scope="col">Acción</th>
						</tr>
					</thead>
					<tbody>
						<% for(Autor autor: autores){ %>
						<tr>
							<th scope="row"><%= autor.getId() %></th>
							<td> <%= autor.getNombre()%>  <%= autor.getApellido() %></td>
							<td><a href="/LibrosAutores/Autores_descripcion?id=<%=autor.getId() %>">ver</a></td>
						</tr>
						<%} %>
					</tbody>
				</table>




			</div>
		</div>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>