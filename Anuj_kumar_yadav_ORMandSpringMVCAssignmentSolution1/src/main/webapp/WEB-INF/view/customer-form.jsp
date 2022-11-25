<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<title>Save Customer</title>
<style>
    h1 { background-color: #33FF33; }
  </style>
</head>

<body>

<br/>
	<h1> CUSTOMER RELATIONSHIP MANAGEMENT</h1>
	<hr>
	<div class="container">

		<p class="h4 mb-4">Enter customer details</p>

		<form
			action="/Anuj_kumar_yadav_ORMandSpringMVCAssignmentSolution1/customer/save"
			method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${customer.id}" />

			<!-- Enter the Student name -->
			<div class="form-inline">
				<label style="padding-right: 40px;" for="lastName">First
					Name: </label> <input type="text" name="firstName"
					value="${customer.firstName}" class="form-control mb-4 col-4"
					placeholder="First Name">
			</div>


			<div class="form-inline">
				<label style="padding-right: 40px;" for="lastName">Last
					Name: </label> <input type="text" name="lastName"
					value="${customer.lastName}" class="form-control mb-4 col-4"
					placeholder="Last Name">
			</div>

			<!-- Enter the customer email -->
			<div class="form-inline">
				<label style="padding-right: 77px;" for="lastName">Email: </label> <input
					type="text" name="email" value="${customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>

			<!-- Save button -->
			<div class="form-inline">
				<label style="padding-right: 102px;" for="btn"></label>
				<button type="submit" name="btn" class="btn btn-info -sm ml-3 mb-2 col-1">Save</button>
			</div>
			<div class="form-inline">
				<label style="padding-right: 118px;" for="back"></label> <a
					name="back" href="show">Back to List</a>
			</div>
		</form>

		<hr>

	</div>
</body>

</html>