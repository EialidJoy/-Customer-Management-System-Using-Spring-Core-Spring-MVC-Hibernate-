<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Customer list</title>
	
	<!-- reference our style sheet -->
	
	<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css" />
	

</head>
<body>

	<div id="wrapper">
	
		<div id="header">
			<h2> Customer Relationship Managemment</h2>
			<h6><i>Made By Eialid Ahmed Joy</i></h6>
	
		</div>
	
	</div>
	<div id="container">
	
		<div id="content">
		
		<input type="button" value="Add Customer"
		onClick="window.location.href='forAddition'; return false;"
		class="add-button"/>
			<table>
				
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
			
				</tr>
				
				<c:forEach var="tempCustomer" items="${attCustomers}">
				
					<!-- constructing update link for each Update button -->
					<c:url var="updateLink" value="/customer/showUpdateForm">
						<c:param name="customerId" value="${tempCustomer.id}">   <!-- saving that id into "customerId" variable and later we will use this in controller class for further fetching data of that id -->
						</c:param>
					
					</c:url>
					
					<!-- Constructing delete link for each delete button -->
					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${tempCustomer.id}">
						</c:param>
					</c:url>
				
						<tr>
							<td> ${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td>
							
							<td>
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}"
								onClick="if(!(confirm('Ae you sure enough to delete the customer?')))return false">Delete</a>
							</td>
						</tr>
				</c:forEach>
				
			</table>
	
		</div>
	
	</div>
	
	</body>
	</html>