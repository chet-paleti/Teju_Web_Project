<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses Page</title>
</head>

<body>

<%
	String  student_id = request.getParameter("id");
    int student = Integer.parseInt(student_id) ;
%>


Here are the courses taken by student <%=student %>

<%
try{ 
Connection cn = (Connection)getServletContext().getAttribute("DBCon");

String query ="SELECT c.title FROM course_student cs, course c where cs.course_id=c.id and cs.student_id =  " + student ;
PreparedStatement st = cn.prepareStatement(query);
ResultSet rs = st.executeQuery();
while(rs.next()){
%>

<ul>
<li> <%=rs.getString("title") %> </li>
</ul>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>


</body>
</html>