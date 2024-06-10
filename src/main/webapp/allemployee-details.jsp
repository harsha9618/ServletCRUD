<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<!--  <div action="//EmployeeServlet" method="get">
<h1>List of Employees</h1>
<input type="submit" value="Submit">

</div> -->
<div class="w-100 p-3">
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand">Employee Management Application</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"></a>
			</ul>
		</nav>


	</header>
	<br>

	<div class="row">

		<div class="container text-left">

			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
				New Employee</a>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>UserName</th>
					<th>Password</th>
					<th>Address</th>
					<th>Contact</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<!--   for (Todo todo: todos) {  -->
				<c:forEach var="employee" items="${listEmployee}">

					<tr>
						<td><c:out value="${employee.id}" /></td>
						<td><c:out value="${employee.firstName}" /></td>
						<td><c:out value="${employee.lastName}" /></td>
						<td><c:out value="${employee.username}" /></td>
						<td><c:out value="${employee.password}" /></td>
						<td><c:out value="${employee.address}" /></td>
						<td><c:out value="${employee.contact}" /></td>
						<td><a href="edit?id=<c:out value='${employee.id}' />">EDIT</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete?id=<c:out value='${employee.id}' />">DELETE</a> 

					</tr>
				</c:forEach>
				<!-- } -->
			</tbody>
		</table>

	</div>
</div>
	<%-- <div action="//EmployeeServlet" method="get">
		<h3 class="text-center">List of Users</h3>
		<hr>
		<div class="container text-left">

			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
				New User</a>
		</div>
		<br>
		</div>

	 --%>






</body>
</html>