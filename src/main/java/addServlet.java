import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve dogs and session attributes as needed.
		HttpSession session = request.getSession(false); 
		
		if (session != null) {
            // Get the user's details from the session
            String owner_email = (String) session.getAttribute("owner_email");
            String owner_name = (String) session.getAttribute("owner_name");
            String owner_password = (String) session.getAttribute("owner_password");
            
            // Get parameters from the form
    		String name = request.getParameter("name");
    		String age = request.getParameter("age");
    		String breed = request.getParameter("breed");
    		String colour = request.getParameter("colour");
    		String activity = request.getParameter("activity");
    		String maintenance = request.getParameter("maintenance");
    		
    		if (name.isEmpty() | age.isEmpty() | breed.isEmpty() | colour.isEmpty() | activity.isEmpty() | maintenance.isEmpty()) {
    			System.out.println("All fields must be filled in!");
    			request.getRequestDispatcher("add.jsp").forward(request, response);
    		} else {
    			// Add dog to the database
    			Dogs dog = new Dogs(name, age, breed, colour, activity, maintenance, owner_name, owner_email, owner_password);
    			try {
    				DogsDAO.instance.insertDog(dog);
    	            
    	            // Set attributes in the session as needed
    	            session.setAttribute("owner_name", owner_name);
    	            session.setAttribute("userDog", dog);
    	            
    	            // Redirect to index.jsp accessible through IndexServlet
    	            response.sendRedirect("IndexServlet");
    	            
    				System.out.println("addServlet: Dog " + name + " successfully added.");
    			} catch (Exception e1) {
    				System.out.println("Couldn't register new dog.");
    				e1.printStackTrace();
    			}
    		}	
		} else {
			System.out.println("No session found. You have to log in.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}