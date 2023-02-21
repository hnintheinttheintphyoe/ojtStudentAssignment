<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="studentRegister.dto.*"%>
<%@page import="studentRegister.dao.*"%>
<%@page import="studentRegister.dao.studentDAO"%>
<%@page import="java.util.*"%>
<div id="sub_content">
	<form action="studentUpdateServlet" method="post"
		enctype="multipart/form-data">

		<h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Details</h2>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="studentID" class="col-md-2 col-form-label">Student
				ID</label>
			<div class="col-md-4">
				<input type="text" class="form-control" value="STU00${res.sid}"
					id="studentID" disabled> <input type="hidden"
					class="form-control" value="${res.sid}" name="sid">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="name" class="col-md-2 col-form-label">Name</label>
			<div class="col-md-4">
				<input type="text" class="form-control" id="name" name="name"
					value="${res.name}">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="dob" class="col-md-2 col-form-label">DOB</label>
			<div class="col-md-4">
				<input type="date" class="form-control" id="dob" name="dob"
					value="${res.dob }">
			</div>
		</div>
		<fieldset class="row mb-4">
			<div class="col-md-2"></div>
			<legend class="col-form-label col-md-2 pt-0">Gender</legend>
			<div class="col-md-4">
				<div class="form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="gridRadios1" value='male'
						<c:if test="${res.gender == 'male'}">checked</c:if>> <label
						class="form-check-label" for="gridRadios1"> Male </label>
				</div>
				<div class="form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="gridRadios2" value="female"
						<c:if test="${res.gender == 'female'}">checked</c:if>> <label
						class="form-check-label" for="gridRadios2"> Female </label>
				</div>

			</div>
		</fieldset>

		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="phone" class="col-md-2 col-form-label">Phone</label>
			<div class="col-md-4">
				<input type="text" class="form-control" id="phone" name="phone"
					value="${res.phone }">
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
				String res = (String) request.getAttribute("ss");

				String str[] = res.split(",");
				List<String> al = new ArrayList<String>();
				al = Arrays.asList(str);
				%>
				<%
				CourseDAO dao = new CourseDAO();
				ArrayList<CourseResponseDTO> list = dao.selectAll();

				for (CourseResponseDTO course : list) {
					
				%>

				<div class="form-check-inline col-md-5">
					<input class="form-check-input" type="checkbox" name="attend"
						id="gridRadios2" value="<%=course.getName()%>"
						<%if (al.contains(course.getName())) {%> checked=checked <%}%>>
					<label class="form-check-label" for="gridRadios2"> <%=course.getName()%>
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
				<img src="${res.photo }" width="100" height="100"> <input
					type="file" class="form-control" id="name" name="photo"
					value="${res.photo }">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-4"></div>
			<div class="col-md-4">

				<button type="submit" class="btn btn-success" data-bs-toggle="modal"
					data-bs-target="#exampleModal">Update</button>
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Student
									Update</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<h5 style="color: rgb(127, 209, 131);">Successfully Update!</h5>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary"
									data-bs-dismiss="modal">OK</button>

							</div>
						</div>
					</div>
				</div>

				<button type="button" class="btn btn-danger  "
					onclick="location.href = 'studentDetailServlet';">Cancel</button>

			</div>

		</div>





	</form>
</div>
<%@ include file="footer.jsp"%>
