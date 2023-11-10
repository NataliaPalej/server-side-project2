import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

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
		
		if (name.isEmpty() || age.isEmpty() || breed.isEmpty() || colour.isEmpty() || activity.isEmpty() || maintenance.isEmpty()) {
			System.out.println("\nAll fields must be filled in!\n");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			Dog dog = new Dog(name, age, breed, colour, activity, maintenance, owner_name, owner_email, owner_password);
			try {
				// Add dog to the database
				DogDAO.instance.insertDog(dog);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				System.out.println("Dog " + name + " successfully registered.\n");
			} catch (Exception e1) {
				System.out.println("Couldn't register new dog.");
				e1.printStackTrace();
			}
		}
	}
}