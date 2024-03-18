<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Teju_Web.Student, java.sql.* "
    %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students Page</title>
</head>
<body>


	<c:choose>
		<c:when test="${sessionScope.studentData eq null}">
					<jsp:forward page="getStudents" />
		</c:when>
				<c:otherwise>
					<h1><c:out value="Here are the Students" /></h1>
				</c:otherwise>
	</c:choose>
	
	<table border=1> 
				<tr>
					
					<td>FIRST NAME</td>
					<td>LAST NAME</td>
					<td>EMAIL</td>
					<td>COURSES</td>
					
				</tr>
				
								
				<c:forEach var="student" items="${sessionScope.studentData}">
				
										
					<c:url var="courseurl" value="/Courses.jsp">
						<c:param name="id" value="${student.id}"></c:param>
					</c:url>
  
					<tr>
						<td>${student.firstname}</td>
						<td>${student.lastname}</td>
						<td>${student.emailid}</td>
						
						
						<td>
							<a href="${courseurl}">Courses</a>
						</td>
						
					</tr>
				</c:forEach>
				
			
				
			</table>


</body>
</html>