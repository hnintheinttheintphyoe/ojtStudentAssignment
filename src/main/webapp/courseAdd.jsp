<%@ include file="header.jsp"%>
<%@page import="studentRegister.dao.*" %>>
    <div id="sub_content">
    <form action="courseServlet" method="post">

        <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Course Registration</h2>
        <%if(request.getAttribute("error") != null){%>
            	<div class="row">
            	<div class="row mb-4">
			<div class="col-md-2"></div>
			<div class="col-md-4">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong>Please!Fill Data in the field.</strong>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
			</div>
            	</div>
            <%} %>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="id" class="col-md-2 col-form-label"> ID</label>
            <div class="col-md-4">
            <%
				CourseDAO dao2 = new CourseDAO();
				int max_id = dao2.getId();
					
				%>
                <input type="text" class="form-control" id="id" name="cid" value="COU00<%=max_id+1%>" readonly>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="name" class="col-md-2 col-form-label">Name</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="name" name="name" >
            </div>
        </div>
      
       
        <div class="row mb-4">
            <div class="col-md-4"></div>

            <div class="col-md-6">
               

                <button type="submit" class="btn btn-secondary col-md-2" data-bs-toggle="modal" data-bs-target="#exampleModal">Add</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Course Registration</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h5 style="color: rgb(127, 209, 131);">Registered Succesfully !</h5>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-success col-md-2" data-bs-dismiss="modal">Ok</button>
                               
                            </div>
                        </div>
                    </div>
            </div>

        </div>
        </form>
    </div>
<%@ include file="footer.jsp"%>