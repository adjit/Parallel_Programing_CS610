/*
1. If we make a cookie with a name and password and make a
second cookie with the same name and different password IE
replaces the first one.
2. For the sake of simplicity assume the user enters strings in all
the input boxes.
*/

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.util.Scanner;

@WebServlet("/Main")
public class Main extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
  private String head, tail; 
  public Main() {
    super();
    head = "<html><title>Not In The List</title><body><font color = blue><h1>";
    tail = "</h1></font></body></html>";
  }   	
	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
    //This method is complete. Do not change it.  
    String userName = request.getParameter("name");
    String password = request.getParameter("password");
    String newPassword = request.getParameter("newPassword");
    String reEnteredPassword = request.getParameter("reEnterPassword");
    displayCookies(request);
    if(isIn(request, userName, password))
      if(isTheSame(newPassword, reEnteredPassword))
        replace(request, response, userName, password, newPassword);
      else
        isNotTheSame(response, newPassword, reEnteredPassword);
    else
      isNotInTheList(response, userName, password);
    displayCookies(request);
  }
  
  private boolean isIn(HttpServletRequest request, String userName, String password){
    //Complete this method.
    //Check the cookies. If one of them has the name: userName and the value: password 
    //return true otherwise return false
	  Cookie[] cookies = request.getCookies();
	  if(cookies != null && cookies.length > 0 ) {
		  for(int i=0; i<cookies.length; i++) {
			  if (cookies[i].getName().equals(userName) && cookies[i].getValue().equals(password))
				  return true;
		  }
	  }
    return false; //Once this method is complete remove this line.
  }  

  private boolean isTheSame(String newPassword, String reEnteredPassword){
    //Complete this method
    //Make sure the user entered the same new password twice. If both
    // newPassword and reEnteredPassword have the same string return true
    // otherwise return false.
	  if (newPassword.equals(reEnteredPassword))
		  return true;
    return false; //Once this method is complete remove this line.
  }
  
  private void replace(HttpServletRequest request, HttpServletResponse response, 
    String userName, String password, String newPassword) throws IOException{
    //Complete this method
    // This is the case that the program is sure there is a cookie with the
    // name: username and the value: password. Replace the value of this
    // cookie by the value of: newPassword.
	  Cookie[] cookies = request.getCookies();
	  for(int i=0; i<cookies.length; i++) {
		  if (cookies[i].getName().equals(userName) && cookies[i].getValue().equals(password)) {
			  cookies[i].setMaxAge(0);
			  Cookie c = new Cookie (userName, newPassword);
			  response.addCookie(c);
			  success(response);
		  }
	  }
  }
  
  private void isNotInTheList(HttpServletResponse response, String userName, String password) throws IOException{
    //Complete this method.
    //Make an html document to display the content of the console.
	  String message = (userName + " with the password: " + password + " is not in the list");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>\n" +
		    "<head><title>Processing</title></head>\n" +
		"<BODY BGCOLOR=\"#FDF5E6\">\n" +
		    "<h1 alighn\"center\">" + message + "</h1>\n" +
		"</body></html>");
		out.close();
    System.out.println(userName + " with the password: " + password + " is not in the list");
  }

  private void isNotTheSame(HttpServletResponse response, String newPassword, 
    String reEnteredPassword) throws IOException{
    //Complete this method.
    //Make an html document to display the content of the console.
	String message = (newPassword + " must be the same as " + reEnteredPassword);
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<html>\n" +
	    "<head><title>Processing</title></head>\n" +
	"<BODY BGCOLOR=\"#FDF5E6\">\n" +
	    "<h1 alighn\"center\">" + message + "</h1>\n" +
	"</body></html>");
	out.close();
    System.out.println(newPassword + " must be the same as " + reEnteredPassword);
  }  
  
  private void success(HttpServletResponse response) throws IOException{
    //Complete this method.
    //Make an html document to display the content of the console.
	  String message = "The password is changed successfully.";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>\n" +
		    "<head><title>Processing</title></head>\n" +
		"<BODY BGCOLOR=\"#FDF5E6\">\n" +
		    "<h1 alighn\"center\">" + message + "</h1>\n" +
		"</body></html>");
		out.close();
    System.out.println("The password is changed successfully.");
  }
  
  private void displayCookies(HttpServletRequest request){
    //This method is complete. Do not change it. This method displays
    // the name and the value of all the cookies.
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0)
      for(int i=0; i<cookies.length; i++)
        System.out.println(cookies[i].getName() + ", " + cookies[i].getValue());
      System.out.println("********************************************************");  
  }
}
