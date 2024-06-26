package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Counter
 */
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Counter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// se crea metodos para contar las veces que se inicia sesion
		
		// se crea una instancia de session para llevar el conteo 
		HttpSession miSesion = request.getSession();
		// se recibe el atributo de veces para contar
		String veces = (String) miSesion.getAttribute("veces");
		
		if(veces == null) {
			veces = "1";
		}else {
			veces = (Integer.parseInt(veces) + 1) + "";
		}
		
		miSesion.setAttribute("veces", veces);
		System.out.println(veces);
		// establece el jsp que se mostrara como vista
		RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/counter.jsp");
		vista.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
