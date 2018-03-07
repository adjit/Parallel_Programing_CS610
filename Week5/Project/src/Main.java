

import java.io.*;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String html = "<html><title>Project 5</title><body bgcolor=\"#fdf5e6\">\n";
		
		String oldName = request.getParameter("oldName");
		String newName = request.getParameter("newName");
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=");
			Statement stmt = con.createStatement();
			stmt.execute("USE mydatabase");
			
			Vector<String> names = new Vector<String>();
			
			String query = "Select * from simple";
			int count = 0;
			
			if(oldName != null) {
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					String name = rs.getString(1);
					//System.out.println("Name retrieved - '" + name + "'");
					if(name.equals(oldName)) {
						names.add(newName);
						query = "Update simple Set name='" + newName + "' Where name='" + oldName + "'";
						count++;
					}
					else names.add(name);
				}
				html += "<h1 style='text-align:center;'>";
				if(count != 0) {
					stmt.executeUpdate(query);
					html += oldName + " FOUND.</h1>";
				}
				else html += oldName + " not found.</h1><br/><br/>";
				
				html += "The content of the table is:<br/><br/>";
				
				for(int i = 0; i < names.size(); i++)
				{
					html += names.get(i).toString() + "<br/>";
				}
			}			
		} catch (Exception ex) {
			System.out.println(ex);
			System.exit(0);
		}
		
		html += "</body></html>";
		PrintWriter out = response.getWriter();
		out.println(html);
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

