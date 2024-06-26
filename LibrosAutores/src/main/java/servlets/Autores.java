package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Autor;
import models.Libro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DAOS.AutorDao;
import DAOS.LibroDao;

/**
 * Servlet implementation class Autores
 */
public class Autores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Autor> autores =  AutorDao.get_autores();
			System.out.println(autores);
			request.setAttribute("autores", autores);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 2. Cargamos el JSP
				RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/autores.jsp");
				
				vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String notas = request.getParameter("notas");
		
		
		try {
			AutorDao.insert_autor(nombre, apellido, notas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/LibrosAutores/Autores");
	}

}
