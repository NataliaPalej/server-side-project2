import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			System.out.println("Before logout session ID: " + session.getId());
			session.removeAttribute("owner_email");
			session.removeAttribute("owner_name");
			session.removeAttribute("owner_password");
			session.removeAttribute("dogDetails");
			session.removeAttribute("allDogs");
			session.invalidate();
			
			
			try {
	            // Get the session ID should throw an exception
	            System.out.println("After logout session ID: " + session.getId());
	        } catch (IllegalStateException e) {
	        	// Should go here because session was deleted????
	            System.out.println("Session has been invalidated.");
	        }
			System.out.println("LogoutServlet: Log out successful.");
		} else {
			System.out.println("No session to close.");
		}
		System.out.println();
		Cookie loginCookie = null;
		Cookie[] cookies =request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("user")) {
					loginCookie = cookie;
					break;
				}
			}
		}
		if (loginCookie != null) {
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
		}
		response.sendRedirect("logout.jsp");
		}
}
