import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DogToUpdate
 */
@WebServlet("/SelectedDog")
public class SelectedDog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectedDog() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String buttonClicked=request.getParameter("userChoice");
		
		// Get details from the session
        String owner_email = (String) session.getAttribute("owner_email");
        String selectedDogName = request.getParameter("name");
        session.setAttribute("selectedDogName", selectedDogName);
       
        try {
        	Dog selectedDog = DogDAO.instance.getDogByName(owner_email, selectedDogName);
    		if (buttonClicked.equalsIgnoreCase("update")){
    		    session.setAttribute("selectedDog", selectedDog);
    		    System.out.println("SelectedDog Servlet: " + selectedDogName + "\n");
    		    request.getRequestDispatcher("update.jsp").forward(request, response);
    		}
    		else if (buttonClicked.equalsIgnoreCase("delete")) {
    			DogDAO.instance.deleteDog(selectedDog.getID());
    			request.getRequestDispatcher("delete.jsp").forward(request, response);
    		    //response.sendRedirect("delete.jsp");
    		}
        } catch (Exception e) {
        	System.out.println("SelectedDog Servlet: error while fetching dog.\n");
        }      
    }
}
