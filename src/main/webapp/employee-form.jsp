<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand"> User Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="conainer col-sm-5">
		<div class="card-body">
		<form action="insert" method="post">
			<c:if test="${employee != null}">
				<form action="update" method="post">
			</c:if>
			
				<caption>
					<h2>
						<c:if test="${employee != null}">
            			Edit Employee
            		</c:if>
						<c:if test="${employee == null}">
            			Add New Employee
            		</c:if>
					</h2>
				</caption>
		
			<c:if test="${employee != null}">
				<input type="hidden" name="id"
					value="<c:out value='${employee.id}' />" />
			</c:if>
			
				<fieldset class="form-group">
					<label>First Name</label> <input type="text" class="form-control"
						name="firstname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name</label> <input type="text" class="form-control"
						name="lastName" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>User Name</label> <input type="text" class="form-control"
						name="username" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label> <input type="text" class="form-control"
						name="password" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Address</label> <input type="text" class="form-control"
						name="addreess" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Contact</label> <input type="text" value=""
						class="form-control" name="contact" required="required">
				</fieldset>
				<button type="submit" class="btn btn-success">Submit</button>
				
			</form>


		</div>

	</div>
</body>
</html>