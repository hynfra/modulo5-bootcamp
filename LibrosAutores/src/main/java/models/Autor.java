package models;

public class Autor {
	
	private int id;
	private String nombre,apellido,notas;
	public Autor(int id, String nombre, String apellido, String notas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.notas = notas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	
	

}
