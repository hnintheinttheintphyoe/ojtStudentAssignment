package studentRegister.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentRegister.dao.UserDAO;
import studentRegister.dao.studentDAO;
import studentRegister.dto.StudentRequestDTO;
import studentRegister.dto.StudentResponseDTO;
import studentRegister.dto.UserRequestDTO;
import studentRegister.dto.UserResponseDTO;
import studentRegister.model.User;

/**
 * Servlet implementation class studentUpdateDelServlet
 */
@WebServlet("/studentUpdateDelServlet")
public class studentUpdateDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentUpdateDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String sid=request.getParameter("sid");
		
		studentDAO dao=new studentDAO();
		StudentRequestDTO dto=new StudentRequestDTO();
		dto.setSid(Integer.parseInt(sid));
		StudentResponseDTO res=dao.findOne(dto);
		String s=res.getAttend();
		request.setAttribute("res", res);
		request.setAttribute("ss",s);
		request.getRequestDispatcher("studentUpdateDel.jsp").forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String uid=request.getParameter("uid");
//		String name=request.getParameter("name");
//		String email=request.getParameter("email");
//		String password=request.getParameter("password");
//		String role=request.getParameter("role");
//		
//		
//		User bean=new User();
//		bean.setUid(Integer.parseInt(uid));
//		bean.setName(name);
//		bean.setEmail(email);
//		bean.setPassword(password);
//		bean.setRole(role);
//		if(bean.getName().equals("") || bean.getEmail().equals("") || bean.getPassword().equals("") || bean.getRole().equals("")) {
//			request.setAttribute("error","Dta cannot be null!");
//			request.setAttribute("bean", bean);
//			request.getRequestDispatcher("userUpate.jsp").forward(request, response);
//		}
//		else {
//		    
//			 UserDAO dao=new UserDAO();
//			    UserRequestDTO dto=new UserRequestDTO();
//			    dto.setUid(bean.getUid());
//			    dto.setName(bean.getName());
//			    dto.setEmail(bean.getEmail());
//			    dto.setPassword(bean.getPassword());
//			    dto.setRole(bean.getRole());
//			    dao.updateData(dto);
//			    response.sendRedirect("userDetailServlet");
//			    //request.getRequestDispatcher("userDetail.jsp").forward(request, response);
//		}
}
	}


