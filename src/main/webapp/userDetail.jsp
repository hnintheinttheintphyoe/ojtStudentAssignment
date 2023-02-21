
<%@ include file="header.jsp"%>
<div id="sub_content">
	<form class="row g-3 mt-3 ms-2" action="userDetailServlet" method="get">
		<div class="col-auto">
			<label for="staticEmail2" class="visually-hidden">User Id</label> <input
				type="number" class="form-control" id="staticEmail2" value="<%=request.getParameter("uid") != null ?request.getParameter("uid"):"" %>"
				placeholder="User ID" name="uid">
		</div>
		<div class="col-auto">
			<label for="inputPassword2" class="visually-hidden">User Name</label>
			<input type="text" class="form-control" id="inputPassword2"
				placeholder="User Name" name="name" value="<%=request.getParameter("name") != null   ? request.getParameter("name") :"" %>">
		</div>

		<div class="col-auto">
			<button type="submit" class="btn btn-primary mb-3" >Search</button>
		</div>
		<div class="col-auto">
			<button type="button" class="btn btn-secondary "
				onclick="location.href = 'register.jsp';">Add</button>

		</div>
		<div class="col-auto">
			<a href="userDetailServlet" class="btn btn-danger mb-3" >Reset</a>
		</div>
	</form>

	<table class="table table-striped" id="stduentTable">
		<thead>
			<tr>

				<th scope="col">User ID</th>
				<th scope="col">User Name</th>
				<th scope="col">Details</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${requestScope.list }" var="data">
				<tr>


					<td>USR00${data.uid }</td>
					<td>${data.name }</td>

					<td>

						<button type="button" class="btn btn-success  "
							onclick="location.href = 'userUpdateServlet?uid=${data.uid}';">
							Update</button>
					</td>
					<td><a href="userDeleteServlet?uid=${data.uid}"
						class="btn btn-secondary mb-3"
						onclick="return confirm('Are you sure you want to delete!')">Delete</a></td>

				</tr>
			</c:forEach>




		</tbody>
	</table>

	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Student
						Deletion</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<h5 style="color: rgb(127, 209, 131);">Are you sure want to
						delete !</h5>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success col-md-2"
						data-bs-dismiss="modal">Ok</button>

				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>