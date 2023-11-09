import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// Retrieve dogs from the session
		List<Dogs> dogDetails;
		try {
			dogDetails = DogsDAO.instance.dogsList();
			// Pass dogList to the index2.jsp
	        request.setAttribute("dogDetails", dogDetails);
	        // Forward to index2.jsp
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}    
	}
}
