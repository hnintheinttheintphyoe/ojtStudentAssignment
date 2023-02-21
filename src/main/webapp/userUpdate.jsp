<%@ include file="header.jsp"%>
<div id="sub_content">
	<form action="userUpdateServlet" method="post">

		<h2 class="col-md-6 offset-md-2 mb-5 mt-4">User Update</h2>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="email" class="col-md-2 col-form-label">Name</label>
			<div class="col-md-4">
				<input type="hidden" name="uid" value="${res.uid }"> <input
					type="text" class="form-control" id="name" name="name"
					value="${res.name }">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="email" class="col-md-2 col-form-label">Email</label>
			<div class="col-md-4">
				<input type="email" class="form-control" id="email" name="email"
					value="${res.email }">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="Passowrd" class="col-md-2 col-form-label">Passowrd</label>
			<div class="col-md-4">
				<input type="password" class="form-control" id="name"
					name="password" value="${res.password }">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="confirmPassword" class="col-md-2 col-form-label">Confirm
				Password</label>
			<div class="col-md-4">
				<input type="password" class="form-control" id="confirmPassword"
					name="cpassword" value="${res.password }">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="userRole" class="col-md-2 col-form-label">User
				Role</label>
			<div class="col-md-4">
				<select class="form-select" aria-label="Education" id="userRole"
					name="role">
					<option selected>Admin</option>
					<option value="1">User</option>


				</select>
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-4"></div>

			<div class="col-md-6">


				<button type="submit" class="btn btn-success col-md-2"
					data-bs-toggle="modal" data-bs-target="#exampleModal">Update</button>
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">User Update</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<h5 style="color: rgb(127, 209, 131);">Succesfully Updated
									!</h5>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-success col-md-2"
									data-bs-dismiss="modal">Ok</button>

							</div>
						</div>
					</div>
				</div>
				<button type="button" class="btn btn-secondary col-md-2 "
					onclick="location.href = 'userDetailServlet';">Back</button>


			</div>
	</form>
</div>
<%@ include file="footer.jsp"%>