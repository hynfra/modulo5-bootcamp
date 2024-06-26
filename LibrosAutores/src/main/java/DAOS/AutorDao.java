package DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Autor;
import models.Libro;
import models.MyConn;

public class AutorDao {
	
	static public ArrayList<Autor> get_autores () throws SQLException {
		// 1. Creamos un ArrayList vacío
		ArrayList<Autor> autores = new ArrayList<Autor>();
		// 2. Pedimos una conección nueva
		Connection conn = MyConn.getConnection();
		// 3. Creamos y ejecutamos la consulta
		Statement consulta = conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from autores");
		
		// 4. Vamos llenando el ArrayList con lo que tenga la respuesta
		while (respuesta.next()) {
			Autor autor = new Autor(
				  respuesta.getInt("id"),
				  respuesta.getString("nombre"),
				  respuesta.getString("apellido"),
				  respuesta.getString("notas")
				  
				  );
			autores.add(autor);
		}
		// 5. Retornamos el ArrayList, ahora lleno
		return autores;
	  }
	
	static public void insert_autor( String nombre, String apellido, String notas ) throws SQLException{
		// 2. Pedimos una conección nueva
				Connection conn = MyConn.getConnection();
				// 3. Creamos y ejecutamos la consulta
				PreparedStatement consulta = conn.prepareStatement("INSERT INTO autores (nombre,apellido,notas) VALUES (?,?,?)"); 
			
				consulta.setString(1, nombre);
				consulta.setString(2, apellido);
				consulta.setString(3, notas);
				
				consulta.executeUpdate();
		
		
		
	}
	
	static public Autor get_autor (int idAutor) throws SQLException {
		// 1. Pedimos una conexion nueva
		Connection conn = MyConn.getConnection();
		// 2. Creamos la consulta
		PreparedStatement stmt = conn.prepareStatement(
			"SELECT * FROM autores WHERE id = (?)"
		);
		stmt.setInt(1, idAutor);
		// 3. Ejecutar la stmt
		ResultSet respuesta = stmt.executeQuery();
		respuesta.next();
		Autor autor = new Autor(
				respuesta.getInt("id"),
				respuesta.getString("nombre"),
				respuesta.getString("apellido"),
				respuesta.getString("notas")
				
				
				);
		
		return autor;
				
	  }
	
	 static public ArrayList<Libro> get_libros (int idAutor) throws SQLException {
			// 1. Pedimos una conexion nueva
						Connection conn = MyConn.getConnection();
						ArrayList<Libro> libros = new ArrayList<Libro>();
						// 2. Creamos la consulta
						PreparedStatement stmt = conn.prepareStatement(
								"select *  from libros\r\n"
								+ "join libroautor on libros.id = libroautor.libro_id\r\n"
								+ "join autores on libroautor.autor_id = autores.id\r\n"
								+ "where autores.id = (?)"
						);
						stmt.setInt(1, idAutor);
						// 3. Ejecutar la stmt
						ResultSet respuesta = stmt.executeQuery();
						while(respuesta.next()) {
							Libro libro = new Libro(
									
									respuesta.getInt("id"),
									respuesta.getString("titulo"),
									respuesta.getString("descripcion")
									
									
									
									);
							libros.add(libro);
						}
						
						
						return libros;
			 
		 }

}
