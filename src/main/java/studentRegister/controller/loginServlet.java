package studentRegister.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentRegister.dao.UserDAO;
import studentRegister.dto.UserRequestDTO;
import studentRegister.dto.UserResponseDTO;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		doGet(request, response);
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
//		if(name == "" || password == "") {
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}
//		else {
			UserDAO dao=new UserDAO();
			UserRequestDTO dto=new UserRequestDTO();
			dto.setName(name);
			dto.setPassword(password);
			UserResponseDTO res=dao.selectOne(dto);
			
			if(res.getName() != null) {
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}
			else {
				request.setAttribute("error","yes");
			  request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}


