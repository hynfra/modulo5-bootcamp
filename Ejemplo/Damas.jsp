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
  <%
  String width_str = request.getParameter("width");
  String height_str = request.getParameter("height");
  if(width_str == null){
	  width_str = "8";
  }
  if(height_str == null){
	  height_str = "8";
  }
  // 3- Transformo los valores a número
  int width = Integer.parseInt(width_str);
  int height = Integer.parseInt(height_str);
  
  %>
  <h1 class="text-center text-primary">Juego de damas</h1>
  <div class="container">
  <div class="tablero">
  
      <%for(int i = 0; i < height; i++){%>
      <div class="fila">
      	<% for(int j = 0; j < width ; j++ ){
      		if(i % 2 )
      		
      		%>
      	}
      
      
      </div>
      
    	  
      <%} %>
      
      
  
  </div>
  
  
  </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>