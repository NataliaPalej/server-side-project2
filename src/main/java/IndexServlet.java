

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DogsController
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Create dogsList which uses instance of DogsDAO and returns with list()
		List<Dogs> dogsList = null;
		
		try {
			dogsList = DogsDAO.instance.dogsList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Add list of dogs attributes to the request
		request.setAttribute("listOfDogs", dogsList);
		
		// Forward updated request and response to display.jsp view
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
