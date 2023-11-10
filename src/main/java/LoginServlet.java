import java.io.IOException;
import java.util.List;
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
    	String owner_email = request.getParameter("owner_email");
    	String password = request.getParameter("password");
    	
    	boolean loginSuccessful = false;
    	
    	try {
    		loginSuccessful = DogDAO.checkLogin(owner_email, password);
  
            if (loginSuccessful) {
            	// Fetch dog details
            	List<Dog> userDogsList = DogDAO.instance.getDogByEmail(owner_email);
            	
            	// Create session with dogs properties in it
            	HttpSession session = request.getSession();
            	session.setAttribute("owner_email", owner_email);
        		session.setAttribute("userDogsList", userDogsList);
        		
            	System.out.println("Login successful.\n");
                response.sendRedirect("login2.jsp");
            } else {
            	System.out.println("Login unsuccessful.\n");
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}