package Teju_Web;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class getStudents
 */
@WebServlet("/getStudents")
public class getStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("entered get students servlet");
		//response.sendRedirect("page1.jsp");
		
		HttpSession sess = request.getSession();
		
		ArrayList<Student> students = new ArrayList<Student>();
		String query = "select * from student" ;
		Connection cn ;
	    cn = (Connection)getServletContext().getAttribute("DBCon");
		try
		{
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			
			while (rs.next())
			{
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setFirstname(rs.getString("first_name"));
			    s.setLastname(rs.getString("last_name"));
			    s.setEmailid(rs.getString("email"));
				
				students.add(s);
			}
		}
		catch (Exception ex)
		{
			//log it
			ex.printStackTrace();
		}
		
		sess.setAttribute("studentData", students);
		response.sendRedirect("Students.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
