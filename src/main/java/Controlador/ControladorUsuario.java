package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ClassUsuarioImp;
import model.TblUsuariocl2;
/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ClassUsuarioImp usuarioDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        super();
        usuarioDAO = new ClassUsuarioImp();
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
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    TblUsuariocl2 usuario = new TblUsuariocl2();
	    usuario.setUsuariocl2(username);

	    TblUsuariocl2 usuarioEncontrado = usuarioDAO.BuscarUsuario(usuario);

	    if (usuarioEncontrado != null) {
	        // Verificar la contraseña
	        if (usuarioEncontrado.getPasswordcl2().equals(password)) {
	            // Login exitoso
	            HttpSession session = request.getSession();
	            session.setAttribute("usuario", usuarioEncontrado);
	            response.sendRedirect(request.getContextPath() + "/index.jsp");
	        } else {
	            // Contraseña incorrecta
	            String mensajeError = "Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.";
	            request.setAttribute("mensaje", mensajeError);
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	    } else {
	        // Usuario no encontrado
	        String mensajeError = "Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.";
	        request.setAttribute("mensaje", mensajeError);
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	}

}
