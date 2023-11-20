import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class LoginServlet
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
    	String owner_password = request.getParameter("password");
    	
    	boolean loginSuccessful = false;
    	
    	try {
    		loginSuccessful = DogDAO.checkLogin(owner_email, owner_password);
  
            if (loginSuccessful) {
            	// Invalidate existing session, if any exist
            	HttpSession existingSession = request.getSession(false);
            	if (existingSession != null) {
            		System.out.println("LoginServlet: Existing session deleted. ID: " + existingSession.getId());
            		existingSession.invalidate();
            	}
            	
            	Cookie loginCookie = new Cookie("user", owner_email);
            	// Setting cookie to expiry after 3min
            	loginCookie.setMaxAge(3*60);
            	System.out.println("LoginServlet Cookie: " + loginCookie);

            	HttpSession session = request.getSession();
            	System.out.println("LoginServlet: New session " + session.getId());
            	List<Dog> dogDetails = DogDAO.instance.getDogByEmail(owner_email);
            	if (dogDetails != null && !dogDetails.isEmpty()) {
            		Dog userDog = dogDetails.get(0);
            		String owner_name = userDog.getOwner_name();
            	    
            	    session.setAttribute("owner_email", owner_email);
                    session.setAttribute("owner_password", owner_password);
                    session.setAttribute("owner_name", owner_name);
                    session.setAttribute("dogDetails", dogDetails);
                    
                    System.out.println("LoginServlet Session Details:\n" + owner_email + " " + owner_password + " " + owner_name + " \n" + dogDetails );
            	}
            	System.out.println("LoginServlet: Login successful.\n");
            	response.addCookie(loginCookie);
                response.sendRedirect("login2.jsp");
            } else {
            	System.out.println("LoginServlet: Login unsuccessful.\n");
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("LoginServlet: Exception during login for " + owner_email);
        }
    }
}