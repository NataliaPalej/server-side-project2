

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get parameters from the form
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String breed = request.getParameter("breed");
		String colour = request.getParameter("colour");
		String activity = request.getParameter("activity");
		String maintenance = request.getParameter("maintenance");
		String owner_name = request.getParameter("owner_name");
		String owner_email = request.getParameter("owner_email");
		String owner_password = request.getParameter("owner_password");
		
		if (owner_name.isEmpty()) {
			owner_name = "Owner Unknown";
		}
		if (name.isEmpty()) {
			name = "Name Unknown";
		}
		
		// Add dog to the database
		Dogs dog = new Dogs(name, age, breed, colour, activity, maintenance, owner_name, owner_email, owner_password);
		try {
			DogsDAO.instance.insertDog(dog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
