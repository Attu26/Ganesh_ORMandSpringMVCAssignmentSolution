<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Directory</title>
</head>
<body>
<div class="container">

		<h3>Customers Directory</h3>
		<hr>

		<!-- Add a search form -->

		<form action="/CRMProject/customer/search" class="form-inline">

			<!-- Add a button -->
			<a href="/CRMProject/customer/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a> 
		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
					
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customer}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CRMProject/customer/showFormForUpdate?customerId=${tempCustomer.id}"
							class="btn btn-primary btn-sm mb-3"> Update </a> <!-- Add "delete" button/link -->
							<a href="/CRMProject/customer/delete?customerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>