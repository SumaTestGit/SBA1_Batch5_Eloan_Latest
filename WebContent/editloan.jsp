<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Loan Application</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<hr />

	<div align=center>
	
		<h2> Edit Loan Application </h2>
		
		<form action="editloan" method="post">
		
			<div>
			
				<div>
					<label for="applicationnumber">Application Number:</label>
				</div>
				
				<div>
					<input type="text" id="applicationnumber" name="applicationnumber">
				</div>
				
			</div>			
			
			<div>
				<div>
					<input type="submit" value="Edit Application">
				</div>
			</div>
						
		</form>
		
	</div>
	
	<hr />
	<!-- read the application number to edit from user and send to 
	     user controller to edit info
	-->

	<jsp:include page="footer.jsp" />

</body>
</html>