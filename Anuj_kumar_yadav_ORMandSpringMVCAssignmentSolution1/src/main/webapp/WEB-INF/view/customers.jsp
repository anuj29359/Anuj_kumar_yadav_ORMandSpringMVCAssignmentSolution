<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">


<title>Insert title here</title>
<style>
    h1 { background-color: #33FF33; }
  </style>
</head>
<body>
	<br>
	<h1>CUSTOMER RELATIONSHIP MANAGEMENT</h1>
	<hr>
	<form action="/Anuj_kumar_yadav_ORMandSpringMVCAssignmentSolution1/customer/search" class="form-inline">

			<!-- Add a button -->
			<a href="/Anuj_kumar_yadav_ORMandSpringMVCAssignmentSolution1/customer/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a> 
			
			<!-- Add search field for Name -->
			<input
				type="search" 
				name="firstName" placeholder="First Name"
				class="form-control-sm ml-5 mr-2 mb-3" /> 
			
			<!-- Add search field for Department -->
			<input type="search"
				name="lastName" placeholder="Last Name" class="form-control-sm mr-2 mb-3" />
			
			<!-- Add search field for Country -->
			<input type="search"
				name="email" placeholder="Email" class="form-control-sm mr-2 mb-3" />

			<!-- Add search button -->
			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>

		</form>
		
		
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${customers}" var="tempCustomer">
					<tr>
						
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="showFormForUpdate?customerId=${tempCustomer.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="delete?customerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
</body>
</html>