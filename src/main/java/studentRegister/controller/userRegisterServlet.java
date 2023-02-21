package studentRegister.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentRegister.dao.UserDAO;
import studentRegister.dto.UserRequestDTO;
import studentRegister.model.User;

/**
 * Servlet implementation class userRegisterServlet
 */
@WebServlet("/userRegisterServlet")
public class userRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user=new User();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("confirmPassword");
		String role=request.getParameter("userRole");
		String name=request.getParameter("name");
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		user.setRole(role);
		if(user.getEmail().equals("") || user.getPassword().equals("") ||user.getRole().equals("")||user.getName().equals("")) {
			request.setAttribute("error","yes");
			request.setAttribute("user", user);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else {
			UserDAO dao=new UserDAO();
			UserRequestDTO dto=new UserRequestDTO();
			dto.setEmail(user.getEmail());
			dto.setPassword(user.getPassword());
			
			dto.setRole(user.getRole());
			dto.setName(user.getName());
			dao.insertData(dto);
			response.sendRedirect("userDetailServlet");
			//request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
		
	}

}
