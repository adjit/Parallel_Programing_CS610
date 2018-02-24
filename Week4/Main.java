

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Vector;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Vector<String> clientList = new Vector<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String html = "<html><title>Project 4</title><body>\n<h1 style='width: 100%; text-align:center;'>";
		
		String name = request.getParameter("yourName");
		if(clientList.contains(name)) {
			html += name + " has already been registered.";
		}
		else {
			clientList.addElement(name);
			html += name + " has been registed.";
		}
		
		html += "</body></html>";
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    PrintWriter out = response.getWriter();
	    out.println(html);
	    /*
	    out.println("<html><title>Hello</title><body>\n");
	    out.println("<font color = blue>");
	    out.println("<h1>Hello there!</h1>\n");
	    out.println("</font>");
	    out.println("</body></html>");*/
	    out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
