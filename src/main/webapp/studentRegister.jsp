<%@ include file="header.jsp"%>
<%@page import="studentRegister.dto.*"%>
<%@page import="studentRegister.dao.*"%>
<%@page import="studentRegister.dao.studentDAO"%>
<%@page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="sub_content">
	<%
	if (request.getAttribute("success") != null) {
	%>
	<div style="color: green;">Insert Data is successful!</div>
	<%
	}
	%>
	
	<form action="studentRegisterServlet" method="post"
		enctype="multipart/form-data">

		<h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Registration</h2>
		<%if(request.getAttribute("error") != null){%>
            	<div class="row">
            	<div class="row mb-4">
			<div class="col-md-2"></div>
			<div class="col-md-4">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong>Please!Fill Data in the field!</strong>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
			</div>
            	</div>
            <%} %>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="studentID" class="col-md-2 col-form-label">Student
				ID</label>
			<div class="col-md-4">
				<%
				studentDAO dao2 = new studentDAO();
				int max_id = dao2.getId();
					
				%>
				<input type="text" class="form-control" value="STU00<%=max_id+1%>"
					id="studentID" disabled>
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="name" class="col-md-2 col-form-label">Name</label>
			<div class="col-md-4">
				<input type="text" class="form-control" id="name" name="name"
				value="${bean.name }"	>
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="dob" class="col-md-2 col-form-label">DOB</label>
			<div class="col-md-4">
				<input type="date" class="form-control" id="dob" name="dob" value="${bean.dob }">
			</div>
		</div>
		<fieldset class="row mb-4">
			<div class="col-md-2"></div>
			<legend class="col-form-label col-md-2 pt-0">Gender</legend>
			<div class="col-md-4">
				<div class="form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="gridRadios1" value="female" checked> <label
						class="form-check-label" for="gridRadios1"> Male </label>
				</div>
				<div class="form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="gridRadios2" value="male"> <label
						class="form-check-label" for="gridRadios2"> Female </label>
				</div>

			</div>
		</fieldset>

		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="phone" class="col-md-2 col-form-label">Phone</label>
			<div class="col-md-4">
				<input type="text" class="form-control" id="phone" name="phone"
					value="${bean.phone }">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="education" class="col-md-2 col-form-label">Education</label>
			<div class="col-md-4">
				<select class="form-select" aria-label="Education" id="education"
					name="education">
					<option selected>Bachelor of Information Technology</option>
					<option value="1">Diploma in IT</option>
					<option value="2">Bachelor of Computer Science</option>

				</select>
			</div>
		</div>
		<fieldset class="row mb-2">
			<div class="col-md-2"></div>
			<legend class="col-form-label col-md-2 pt-0">Attend</legend>


			<div class="col-md-4">

				<%
				CourseDAO dao = new CourseDAO();
				ArrayList<CourseResponseDTO> list = dao.selectAll();

				for (CourseResponseDTO course : list) {
				%>
				<div class="form-check-inline col-md-5">
					<input class="form-check-input" type="checkbox" name="attend"
						id="gridRadios2" value="<%=course.getName()%>"> <label
						class="form-check-label" for="gridRadios2"> <%=course.getName()%>
					</label>
				</div>
				<%
				}
				%>



			</div>

		</fieldset>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="name" class="col-md-2 col-form-label">Photo</label>
			<div class="col-md-4">
				<input type="file" class="form-control" id="name" name="photo">
			</div>
		</div>

		<div class="row mb-4">
			<div class="col-md-4"></div>

			<div class="col-md-4">
				<button type="reset" class="btn btn-danger ">Reset</button>
				<button type="submit" class="btn btn-secondary col-md-2"
					data-bs-toggle="modal" data-bs-target="#exampleModal">Add</button>
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Student
									Registration</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<h5 style="color: rgb(127, 209, 131);">Registered
									Succesfully !</h5>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-success col-md-2"
									data-bs-dismiss="modal">Ok</button>

							</div>
						</div>
					</div>
				</div>
			</div>


		</div>





	</form>
</div>
<%@ include file="footer.jsp"%>
