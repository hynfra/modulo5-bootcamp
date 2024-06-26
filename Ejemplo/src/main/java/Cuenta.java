

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Cuenta
 */
public class Cuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String numero = req.getParameter("num");
		String numeros = "";
			for(int i = Integer.parseInt(numero); i >= 1 ; i--) {
				numeros +="<li>" + i + "</li>";
			}
			
		
		
		
		String html = """
				
				<html>
				<head>
				<title>cuenta</title>
				<meta charset="UTF-8">
				</head>
				<body>
					<h2>evento cuenta regresiva</h2>
					<ul>
					""" +numeros + """
				</ul>
				<h3>Feliz año!</h3>
				</body>
				</html>
				""";
		
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
