<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="all_css.jsp"%>
</head>
<body class="bg-light">
	<%@ include file="navbar.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Student</p>
						
						<c:if test="${not empty sucMsg }">
						<p class="text-center text-success">${sucMsg }</p>
						<c:remove var="sucMsg"/>
						</c:if>
						
						<c:if test="${not empty errorMsg }">
						<p class="text-center text-success">${errorMsg }</p>
						<c:remove var="errorMsg"/>
						</c:if>
						
						<form action="register" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									class="form-control" name="name">
							</div>
							<div class="mb-3">
								<label class="form-label">Date Of Birth</label> <input
									type="date" class="form-control" name="dob">
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input type="text"
									class="form-control" name="address">
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									type="text" class="form-control" name="qualification">
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="email"
									class="form-control" name="email">
							</div>

							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>