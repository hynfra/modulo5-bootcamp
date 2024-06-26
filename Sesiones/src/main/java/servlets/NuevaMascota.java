package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NuevaMascota
 */
@WebServlet("/NuevaMascota")
public class NuevaMascota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaMascota() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recibimos los parámetros del formulario
		String nombre = (String) request.getParameter("nombre");
		String especie = (String) request.getParameter("especie");
		String edad = (String) request.getParameter("edad");
		// devolvemos una vista
		String parametros = "%s - %s - %s".formatted(nombre, especie, edad);
		
		// se los pasamos al JSP
		request.setAttribute("nombre", nombre);
		request.setAttribute("especie", especie);
		request.setAttribute("edad", edad);
		
		// cargamos la vista
		RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/mascota_agregada.jsp");
		vista.forward(request, response);
	}

}



