package classes;

public class CalculadoraModel {
	
	static public int Operar(String operador, int numero1, int numero2) {
		
		if(operador.equals("sumar")) {
			return numero1 + numero2;
		}else if(operador.equals("restar")) {
			return numero1 - numero2;
		}else if(operador.equals("division")) {
			return numero1 / numero2;
		}else if(operador.equals("multiplicacion")) {
			return numero1 * numero2;
		}
		else {
			return 0;
		}
	}

}
