import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserSessionCreate
 */
@WebServlet("/UserSessionCreate")
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
    	
		// Create user object
		User u = new User(email, password);
		
		try {
			if (UserDAO.checkLogin(email, password) == true) {
				HttpSession s = request.getSession();
				s.setAttribute("user", u);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				System.out.println("Logged in successfully, going to index.jsp");
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
				System.out.println("Wrong login details, going back to login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
