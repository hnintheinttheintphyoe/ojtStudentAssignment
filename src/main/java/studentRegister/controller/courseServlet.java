package studentRegister.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentRegister.dao.CourseDAO;

import studentRegister.dto.CourseRequestDTO;

import studentRegister.model.Course;

/**
 * Servlet implementation class courseServlet
 */
@WebServlet("/courseServlet")
public class courseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("courseAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		//String cid=request.getParameter("cid");
		String name=request.getParameter("name");
		
		Course course=new Course();
		//course.setCid(Integer.parseInt(cid));
		course.setName(name);
		
		if(course.getName().equals("")) {
			request.setAttribute("error","yes");
		request.getRequestDispatcher("courseAdd.jsp").forward(request, response);
		}
		else {
			CourseDAO dao=new CourseDAO();
			CourseRequestDTO dto=new CourseRequestDTO();
		
			dto.setName(course.getName());
			dao.insertData(dto);
			request.getRequestDispatcher("courseAdd.jsp").forward(request, response);
			
		}
	}

}
