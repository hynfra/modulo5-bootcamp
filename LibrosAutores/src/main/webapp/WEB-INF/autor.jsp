<%@page import="models.Libro"%>
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
	<% Autor autor = (Autor)request.getAttribute("autor"); %>
    	<div class="row">
	    	<div class="col-12">
	    	<h1> <%= autor.getNombre() %> <%= autor.getApellido() %></h1>
	    	</div>
	    	<div class="col-3">
	    		<h3>id</h3>
	    	</div>
	    	<div class="col-3">
	    		<h5><%= autor.getId() %></h5>
	    	</div>
	    	</div>
	    	<div class="row">
		    	<div class="col-3">
		    		<h3>Descripcion</h3>
		    	</div>
		    	<div class="col-3">
		    		<h5> <%= autor.getNotas() %></h5>
		    	
		    	</div>
		    	<% ArrayList<Libro> libros = (ArrayList<Libro>) request.getAttribute("libros"); %>
		    	<div class="col-12">
		    		<h3>Libros del autor</h3>
		    			<ul class="list-group">
		    			<% for(Libro libro: libros){%>
		    				<li class="list-group-item"> <%= libro.getTitulo() %> </li>
		    				
		    			<% } %>
		    			</ul>
		    			
		    			
		    	
		    	</div>
		    	<form >
		    	<div class="col-3">
		    	 <div class="form-group">
				    <label for="exampleFormControlSelect1">Example select</label>
				    <select class="form-control" id="exampleFormControlSelect1">
				      <option>1</option>
				      <option>2</option>
				      <option>3</option>
				      <option>4</option>
				      <option>5</option>
				    </select>
				  </div>
		    	</div>
		    	<div class="col-3">
		    		
		    			<button type="submit" class="btn btn-primary">Agregar</button>
		    	</div>
		    	</form>
	    	</div>
    
    
    	
    
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>