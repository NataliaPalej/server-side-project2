

import java.io.IOException;
import java.sql.SQLException;
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
        // Handle GET requests here, e.g., to display the page with dog details.
        // Retrieve dogs and session attributes as needed.
		HttpSession session = request.getSession(false); 
		
		try {
			if (session != null) {
	            // Get the user's email from the session
	            String userEmail = (String) session.getAttribute("user");
	            List<Dogs> dogDetails = DogsDAO.instance.getDogByEmail(userEmail);
	            request.setAttribute("dogDetails", dogDetails);
	            request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
	            System.out.println("No session found. You have to log in.");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
		} catch (Exception e) {
            System.out.println("Error couldn't retrieve dog's details.");
            e.printStackTrace();
        }
		
    }
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Use existing session or return null if no session exists
		HttpSession session = request.getSession(false); 
		
		if (session != null) {
            // Get the user's email from the session
            String userEmail = (String) session.getAttribute("user");

            try {
                List<Dogs> dogs = DogsDAO.instance.getDogByEmail(userEmail);

                if (dogs != null && !dogs.isEmpty()) {
                	// Get the user's dog from the list
                    Dogs userDog = dogs.get(0); 

                    String owner_name = userDog.getOwner_name();
                    session.setAttribute("owner_name", owner_name);
                    session.setAttribute("userDog", userDog);
                    request.setAttribute("dogDetails", dogs);

                    System.out.println("Dog details: " + userDog.getName());
                    System.out.println("Dog was successfully fetched.\n");
                    System.out.println(userDog.getName() + "\n");

                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    System.out.println("Error, couldn't fetch dog details");
                }
            } catch (Exception e) {
                System.out.println("Error couldn't retrieve dog's details.");
                e.printStackTrace();
            }
        } else {
            System.out.println("No session found. You have to log in.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
