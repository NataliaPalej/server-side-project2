import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DogsController
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve session attributes
		HttpSession session = request.getSession(false); 
		
		if (session != null) {
			String owner_email = (String) session.getAttribute("owner_email");
			updateDogDetailsInSession(request, owner_email);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			System.out.println("No session found. You have to log in.\n");
            request.getRequestDispatcher("login.jsp").forward(request, response);
		}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Use existing session or return null if no session exists
		HttpSession session = request.getSession(false); 
		
		if (session != null) {
            // Get the user's email from the session
            String owner_email = (String) session.getAttribute("owner_email");

            try {
                List<Dog> dogs = DogDAO.instance.getDogByEmail(owner_email);

                if (dogs != null && !dogs.isEmpty()) {
                	// Get first dog that matches the email to retrieve person's name
                    Dog userDog = dogs.get(0); 

                    String owner_name = userDog.getOwner_name();
                    String owner_password = userDog.getOwner_password();
                    
                    session.setAttribute("owner_name", owner_name);
                    session.setAttribute("owner_password", owner_password);
                    session.setAttribute("userDog", userDog);
                    request.setAttribute("dogDetails", dogs);
                    
                    updateDogDetailsInSession(request, owner_email);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    System.out.println("Error, couldn't fetch dog details.\n");
                }
            } catch (Exception e) {
                System.out.println("Error couldn't retrieve dog's details.\n");
                e.printStackTrace();
            }
        } else {
            System.out.println("No session found. You have to log in.\n");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
	
	private void updateDogDetailsInSession(HttpServletRequest request, String owner_email) {
        try {
            List<Dog> dogDetails = DogDAO.instance.getDogByEmail(owner_email);
            HttpSession session = request.getSession();
            session.setAttribute("dogDetails", dogDetails);
        } catch (Exception e) {
            System.out.println("Error updating dog details in session.\n");
            e.printStackTrace();
        }
    }
}