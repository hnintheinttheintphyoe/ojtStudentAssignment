<%@ include file="header.jsp"%>

<div id="sub_content">
	<form class="row g-3 mt-3 ms-2" action="studentDetailServlet" method="get">
		<div class="col-auto">
			<label for="staticEmail2" class="visually-hidden">studentID</label> <input
				type="number" class="form-control" id="staticEmail2" name="sid"
				placeholder="Student ID" value="<%=request.getParameter("sid") != null ?request.getParameter("sid"):"" %>">
		</div>
		<div class="col-auto">
			<label for="inputPassword2" class="visually-hidden">studentName</label>
			<input type="text" class="form-control" id="inputPassword2" name="name"
				placeholder="Student Name" value="<%=request.getParameter("name") != null ?request.getParameter("name"):"" %>">
		</div>
		<div class="col-auto">
			<label for="inputPassword2" class="visually-hidden">Course</label> <input
				type="text" class="form-control" id="inputPassword2" name="attend"
				placeholder="Course" value="<%=request.getParameter("attend") != null ?request.getParameter("attend"):"" %>">
		</div>
		<div class="col-auto">
			<button type="submit" class="btn btn-success mb-3">Search</button>
		</div>
		<div class="col-auto">
			<a href="studentDetailServlet" class="btn btn-secondary mb-3">Reset</a>
		</div>
		<div class="col-auto">
			<a href="studentRegister.jsp" class="btn btn-secondary mb-3">Add</a>
		</div>
	</form>
	<div>
		<table class="table table-striped" id="stduentTable">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Student ID</th>
					<th scope="col">Name</th>
					<th scope="col">Course Name</th>
					<th scope="col">Details</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list }" var="data">
					<tr>
						<th scope="row">${data.sid }</th>
						<c:choose>
							<c:when test="${data.sid <10}">
								<td>STU000${data.sid }</td>
							</c:when>
							<c:when test="${data.sid>=10 }">
								<td>STU00${data.sid }</td>
							</c:when>
						</c:choose>
						<td>${data.name }</td>
						<td>${data.attend }</td>
						<td><a href="studentUpdateDelServlet?sid=${data.sid}"><button
									type="submit" class="btn btn-secondary mb-2">See More</button></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>
<%@ include file="footer.jsp"%>








