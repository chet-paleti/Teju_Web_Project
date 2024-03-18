package Teju_Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_2
 */
@WebServlet("/Servlet_2")
public class Servlet_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
	    ServletOutputStream out = res.getOutputStream();
	    
	     out.println("<html>");
	     out.println("<head>");
	     out.println("<title>This is a welcome user page </title>");
	     out.println("</head>");
	     out.println("<body>");
	     //out.println("<p>");
	     
	     out.println("<form name=\"f1\" method=\"post\" action=\"Servlet_3\">");
	     out.println("<p>Username:");
         out.println("<input type=\"text\" name=\"uname\">");
         out.println("<input type=\"submit\" name=\"btn1\" value=\"Send\" >");

	     out.println("</p>");
	     out.println("</form>");
	     
	     
	     out.println("</body>");
	     out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Just Testing ...");
		doGet(request, response);
	}

}
