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
import studentRegister.model.User;

/**
 * Servlet implementation class userUpdateServlet
 */
@WebServlet("/userUpdateServlet")
public class userUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String uid=request.getParameter("uid");
		
		UserDAO dao=new UserDAO();
		UserRequestDTO dto=new UserRequestDTO();
		dto.setUid(Integer.parseInt(uid));
		UserResponseDTO res=dao.findOne(dto);
		
		request.setAttribute("res", res);
		request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String uid=request.getParameter("uid");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		
		
		User bean=new User();
		bean.setUid(Integer.parseInt(uid));
		bean.setName(name);
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setRole(role);
		if(bean.getName().equals("") || bean.getEmail().equals("") || bean.getPassword().equals("") || bean.getRole().equals("")) {
			request.setAttribute("error","Dta cannot be null!");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("userUpate.jsp").forward(request, response);
		}
		else {
		    
			 UserDAO dao=new UserDAO();
			    UserRequestDTO dto=new UserRequestDTO();
			    dto.setUid(bean.getUid());
			    dto.setName(bean.getName());
			    dto.setEmail(bean.getEmail());
			    dto.setPassword(bean.getPassword());
			    dto.setRole(bean.getRole());
			    dao.updateData(dto);
			    response.sendRedirect("userDetailServlet");
			    //request.getRequestDispatcher("userDetail.jsp").forward(request, response);
		}
	}

	}


