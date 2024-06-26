<%@page import="models.Libro"%>
<%@page import="DAOS.LibroDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Nuevo JSP con bootstrap</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
<% ArrayList<Libro> libros =(ArrayList<Libro>) request.getAttribute("libros"); %>
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
			<h1>Agregar un libro</h1>
				<form  action="/LibrosAutores/Libros" method="post">
					<div class="form-group">
						<label for="titulo">Titulo</label>
						 <input type="text" class="form-control" id="titulo" name="titulo"
							aria-describedby="emailHelp" placeholder="Ingresa el titulo del libro" required>
					</div>
					<div class="form-group">
						<label for="titulo">Descripcion</label> 
						<textarea class="form-control" id="descripcion" name="descripcion" rows="3" required></textarea>
					</div>
					
					<button type="submit" class="btn btn-primary">Agregar</button>
				</form>

			</div>
			<div class="col-md-6">

				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">TITULO</th>
							<th scope="col">Accion</th>
						</tr>
					</thead>
					<tbody>
					<% for(Libro libro: libros){ %>
						<tr>
							<th scope="row"><%= libro.getSerial() %></th>
							<td><%= libro.getTitulo() %></td>
							<td><a href="/LibrosAutores/Libros_descripcion?id=<%=libro.getSerial() %>">View</a></td>
						</tr>
						<%} %>
					</tbody>
				</table>




			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>