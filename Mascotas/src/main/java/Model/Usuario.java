package Model;

public class Usuario {
	String username;
	String password;
	
	static public boolean loginExitoso(String username, String password) {
		String [] nombres = {"juanito","melon","elvis"};
		String [] claves = {"perez", "melame","cocho"};
		boolean nombreusuario = false;
		boolean clave = false;
		for(int i = 0; i < nombres.length; i++) {
			if(username.equals(nombres[i])) {
				nombreusuario = true;
			}
		}
		for(int i = 0; i < claves.length; i++) {
			if(password.equals(claves[i])) {
				clave = true;
			}
		}
		if(nombreusuario) {
			if(clave) {
				return true;
			}
		}
		
		
		return false;
	}

}
