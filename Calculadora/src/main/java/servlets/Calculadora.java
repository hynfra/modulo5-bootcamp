package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import classes.CalculadoraModel;

/**
 * Servlet implementation class Calculadora
 */
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Calculadora() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String resultado = (String) session.getAttribute("resultado");
		if(resultado == null) {
			session.setAttribute("resultado", "0");
		}
		RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/calculadora.jsp");// se establece la ruta de la vista a mostrar
		vista.forward(request, response);// establece la vista
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numero1 =Integer.parseInt(request.getParameter("numero1"));
		int numero2 =Integer.parseInt(request.getParameter("numero2"));
		String operador = request.getParameter("operador");
		int resultado = CalculadoraModel.Operar(operador, numero1, numero2);
		HttpSession session = request.getSession();
		session.setAttribute("resultado", resultado + "");
		response.sendRedirect("/Calculadora/Calculadora");
		//request.setAttribute("resultado", CalculadoraModel.Operar(operador, numero1, numero2));
		//response.getWriter().append("Se recibio " + numero1 + " " + operador + " " + numero2);
	}

}
