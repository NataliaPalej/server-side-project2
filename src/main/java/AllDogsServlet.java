import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OtherDogsController
 */
@WebServlet("/AllDogsServlet")
public class AllDogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllDogsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve dogs and session attributes as needed.
		HttpSession session = request.getSession(false);
		
		// Retrieve all dogs
		List<Dog> allDogs;
		try {
			allDogs = DogDAO.instance.dogsList();
			// Pass dogList to the indexAllDogs.jsp
	        session.setAttribute("allDogs", allDogs);
	        // Forward to indexAllDogs.jsp
			request.getRequestDispatcher("indexAllDogs.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}    
	}
}
