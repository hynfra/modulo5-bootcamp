package models;

public class Libro {
	
	private int serial;
	private String titulo,descripcion;
	public Libro(int serial, String titulo, String descripcion) {
		super();
		this.serial = serial;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
