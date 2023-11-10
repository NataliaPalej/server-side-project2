import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int owners_count = DogDAO.instance.ownersCount();
			int dogs_count = DogDAO.instance.dogsCount();
			
			HttpSession session = request.getSession();
			// Set counts as attributes in request
			session.setAttribute("owners_count", owners_count);
			session.setAttribute("dogs_count", dogs_count);
			System.out.println("Owners count: " + owners_count + "\nDogs count: " + dogs_count);
			response.sendRedirect("register.jsp");
			//request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (Exception e) {
        	System.out.println("Couldn't fetch owners and dogs count.");
            e.printStackTrace();
        }
	}

}
