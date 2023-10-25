import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create userList which uses instance of UserDAO and returns with list()
		List<User> userList = UserDAO.instance.list();
		
		// Add list of users attributes to the request
		request.setAttribute("listOfUsers", userList);
		
		// Forward updated request and response to display.jsp view
		request.getRequestDispatcher("displayList.jsp").forward(request, response);
	}
}
