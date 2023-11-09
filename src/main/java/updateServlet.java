

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(
			"jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Get parameters from the form
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String breed = request.getParameter("breed");
		String colour = request.getParameter("colour");
		String activity = request.getParameter("activity");
		String maintenance = request.getParameter("maintenance");
		String owner_name = request.getParameter("owner_name");
		String owner_email = request.getParameter("owner_email");
		String owner_password = request.getParameter("owner_password");
		
		// Update dog
		Dogs dog = new Dogs(name, age, breed, colour, activity, maintenance, owner_name, owner_email, owner_password);
		try {
			DogsDAO.instance.updateDog(dog.getID());
			request.getRequestDispatcher("index.jsp").forward(request, response);
			System.out.println("Dog was successfully updated.");
		} catch (Exception e1) {
			System.out.println("Couldn't update the dog.");
			e1.printStackTrace();
		}
	}
}
