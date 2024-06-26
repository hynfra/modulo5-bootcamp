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

public class LibroDao {
	
	static public ArrayList<Libro> get_libros () throws SQLException {
		// 1. Creamos un ArrayList vacío
		ArrayList<Libro> libros = new ArrayList<Libro>();
		// 2. Pedimos una conección nueva
		Connection conn = MyConn.getConnection();
		// 3. Creamos y ejecutamos la consulta
		Statement consulta = conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from libros");
		
		// 4. Vamos llenando el ArrayList con lo que tenga la respuesta
		while (respuesta.next()) {
		  Libro libro = new Libro(
				  respuesta.getInt("id"),
				  respuesta.getString("titulo"),
				  respuesta.getString("descripcion")
				  
				  );
		  libros.add(libro);
		}
		// 5. Retornamos el ArrayList, ahora lleno
		return libros;
	  }
	
	static public void insert_libros( String titulo, String descripcion ) throws SQLException{
		// 2. Pedimos una conección nueva
				Connection conn = MyConn.getConnection();
				// 3. Creamos y ejecutamos la consulta
				PreparedStatement consulta = conn.prepareStatement("INSERT INTO libros (titulo,descripcion) VALUES (?,?)"); 
			
				consulta.setString(1, titulo);
				consulta.setString(2, descripcion);
				
				consulta.executeUpdate();
		
		
		
	}
	
	 static public Libro get_libro (int idLibro) throws SQLException {
			// 1. Pedimos una conexion nueva
			Connection conn = MyConn.getConnection();
			// 2. Creamos la consulta
			PreparedStatement stmt = conn.prepareStatement(
				"SELECT * FROM libros WHERE id = (?)"
			);
			stmt.setInt(1, idLibro);
			// 3. Ejecutar la stmt
			ResultSet respuesta = stmt.executeQuery();
			respuesta.next();
			Libro libro = new Libro(
					respuesta.getInt("id"),
					respuesta.getString("titulo"),
					respuesta.getString("descripcion")
					
					
					);
			
			return libro;
					
		  }
	 static public Autor get_autor (int idLibro) throws SQLException {
		// 1. Pedimos una conexion nueva
					Connection conn = MyConn.getConnection();
					// 2. Creamos la consulta
					PreparedStatement stmt = conn.prepareStatement(
						"select *  from autores\r\n"
						+ "join libroautor on autores.id = libroautor.autor_id\r\n"
						+ "join libros on libroautor.libro_id = libros.id\r\n"
						+ "where libros.id = (?)"
					);
					stmt.setInt(1, idLibro);
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
	
	

}
