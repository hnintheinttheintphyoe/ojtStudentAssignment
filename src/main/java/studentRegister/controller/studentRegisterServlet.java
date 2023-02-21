package studentRegister.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import studentRegister.dao.UserDAO;
import studentRegister.dao.studentDAO;
import studentRegister.dto.StudentRequestDTO;
import studentRegister.dto.UserRequestDTO;
import studentRegister.model.Student;

/**
 * Servlet implementation class studentRegisterServlet
 */
@WebServlet("/studentRegisterServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class studentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public studentRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("studentRegister.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();

		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String education = request.getParameter("education");
		String attend[] = request.getParameterValues("attend");
		String myString = "";

		if (attend != null) {
			for (int i = 0; i < attend.length; i++) {
				myString += attend[i] + ",";
			}
		}

		Student bean = new Student();

		bean.setName(name);
		bean.setDob(dob);
		bean.setGender(gender);
		bean.setPhone(phone);
		bean.setEducation(education);
		bean.setAttend(myString);
		
		Part photo = request.getPart("photo");
		if (!photo.getSubmittedFileName().isEmpty()) {
			String appPath = request.getServletContext().getRealPath("");
			// constructs path of the directory to save uploaded file
			String savePath = appPath + File.separator + "upload";

			// creates the save directory if it does not exists
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}

			String fileName = photo.getSubmittedFileName();
			String filePath = savePath + File.separator + fileName;
			photo.write(filePath);
			bean.setPhoto("upload/" + fileName);
		}

		if (bean.getName().equals("") || bean.getDob().equals("") || bean.getGender().equals("")
				|| bean.getEducation().equals("") || bean.getAttend().equals("") || bean.getPhoto()==null) {
			request.setAttribute("error","yes");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("studentRegister.jsp").forward(request, response);
		} else {
			studentDAO dao = new studentDAO();
			StudentRequestDTO dto = new StudentRequestDTO();
			dto.setName(bean.getName());
			dto.setDob(bean.getDob());
			dto.setGender(bean.getGender());
			dto.setPhone(bean.getPhone());
			dto.setEducation(bean.getEducation());
			dto.setAttend(bean.getAttend());
			dto.setPhoto(bean.getPhoto());

			dao.insertData(dto);
			request.setAttribute("success", "yes");
			request.getRequestDispatcher("studentRegister.jsp").forward(request, response);

		}
	}

}
