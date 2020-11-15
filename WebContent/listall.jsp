<%@page import="com.wellsfargo.evaluation.eloan.model.LoanInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Loans</title>
</head>
<body>

	<h1>All Loan Applications</h1>

	<% LoanInfo loan = (LoanInfo) request.getAttribute("loan"); %>

	<table>

		<tr>
			<td>Application Number</td>
			<td><strong> <%=loan.getApplno()%></strong></td>
		<tr>
		<tr>
			<td>Amount Requested</td>
			<td><strong> <%=loan.getAmtrequest()%></strong></td>
		<tr>
		<tr>
			<td>Billing Indicator</td>
			<td><strong> <%=loan.getBindicator()%></strong></td>
		<tr>
		<tr>
			<td>Loan Application Date</td>
			<td><strong> <%=loan.getDoa()%>
			</strong></td>
		</tr>
		<tr>
			<td>Mobile Number</td>
			<td><strong> <%=loan.getMobile()%></strong></td>
		</tr>
		<tr>
			<td>Loan Application Status</td>
			<td><strong> <%=loan.getStatus()%></strong></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><strong> <%=loan.getAddress()%></strong></td>
		</tr>
		
	</table>

	<!-- write code to display all the loan details 
             which are received from the admin controllers' listall method
	-->

</body>
</html>