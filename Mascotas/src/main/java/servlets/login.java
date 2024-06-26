package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Model.Usuario;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// este metodo le devuelve el formulario para agregar mascotas
		
		RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/login.jsp");// se establece la ruta de la vista a mostrar
		vista.forward(request, response);// establece la vista
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		
		
		// devolvemos una vista
		//String parametros = "%s - %s".formatted(username, password);
		//response.getWriter().append(parametros).append(request.getContextPath());
		
		// se los pasamos al JSP
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		if(Usuario.loginExitoso(username, password)) {
			
			// cargamos la vista
			RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/logeado.jsp");
			vista.forward(request, response);
			
		}
		else {
			String redirectUrl = "http://localhost:8080/Mascotas/login";
			response.sendRedirect(redirectUrl);
		}
		
		
	}

}
