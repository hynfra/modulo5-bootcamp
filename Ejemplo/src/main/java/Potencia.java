

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Potencia
 */
public class Potencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Potencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// este programa recibe 2 parametros, base y exp
		// e imprime en una pagina html base elevada a exponente
		String base = req.getParameter("base"); // recibe el parametro atravees de la url
		String exponente = req.getParameter("exponente"); 
		int resultado = 0;
		if(base == null) {
			base = "no encontrado";
			
		}else if(exponente == null) {
			exponente = "no encontrado";
		}else {
			resultado =(int) Math.pow(Integer.parseInt(base), Integer.parseInt(exponente));
			
		}
		
		 
		
		
		//
		res.setContentType("text/html");
		String html = """
				<html>
				<head>
				<title>Saludos</title>
				</head>
				<body>
					<h2>la respuesta de %s elevada a %s es: %s</h2>
				</body>
				</html>
				""".formatted(base,exponente,resultado);
		
		res.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
