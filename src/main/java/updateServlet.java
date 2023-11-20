import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		// Retrieve details from the session
		Dog dogToUpdate = (Dog) session.getAttribute("selectedDog");
		
		// Get parameters from the form
		String name = dogToUpdate.getName();
		String age = request.getParameter("age");
		String breed = request.getParameter("breed");
		String colour = request.getParameter("colour");
		String activity = request.getParameter("activity");
		String maintenance = request.getParameter("maintenance");
		String owner_name = request.getParameter("owner_name");
		String owner_email = request.getParameter("owner_email");
		String owner_password = request.getParameter("owner_password");
		
		try {
			// Retrieve email from the session
			String ownerEmail = (String) session.getAttribute("owner_email");
			System.out.println("UpdateServlet: Owner Email from Session: " + ownerEmail);
			
			// Update dog
			Dog updatedDog = new Dog(name, age, breed, colour, activity, maintenance, owner_name, owner_email, owner_password);
			DogDAO.instance.updateDog(updatedDog);
			
			List<Dog> updatedDogList = DogDAO.instance.getDogByEmail(ownerEmail);
			if (updatedDogList != null) {
				System.out.println("UpdateServlet: updatedDogList != null");
				System.out.println();
				for (Dog dog : updatedDogList) {
			        System.out.println(dog.printDetails());
			    }
				System.out.println();
			    session.setAttribute("dogDetails", updatedDogList);
			} else {
				System.out.println("UpdateServlet: updatedDogList is null");
			}
			
			// Update the session with updated list 
			session.removeAttribute("selectedDog");

			response.sendRedirect("IndexServlet");
				
		} catch (Exception e) {
			System.out.println("UpdateServlet: something went wrong");
		}
	}
}
