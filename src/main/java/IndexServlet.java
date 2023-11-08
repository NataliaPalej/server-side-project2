

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
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    String userEmail = (String) session.getAttribute("email");
	    
	    //if (userEmail != null) {
	        // Get dogs associated with the logged-in user's email
			try {
				List<Dogs> userDog = DogsDAO.instance.getDogByUserEmail(userEmail);
				
				// Add the list of dogs to the request
		        request.setAttribute("dogsList", userDog);

		        request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}       
	    //} else {
	    //    response.sendRedirect("login.jsp");
	    //}
	}

}
