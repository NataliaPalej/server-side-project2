import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class UserSessionCreate
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Get parameters from the form
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	
    	boolean loginSuccessful = false;
    	
    	try {
    		Connection connection = DogsDAO.getConnection();
    		
    		loginSuccessful = DogsDAO.checkLogin(email, password);
  
            if (loginSuccessful) {
            	HttpSession session = request.getSession();
        		session.setAttribute("user", email);
            	System.out.println("Login successful.");
                response.sendRedirect("login2.jsp");
            } else {
            	System.out.println("Login unsuccessful.");
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

		// Create user object
		//User u = new User(email, password);
    }
}
