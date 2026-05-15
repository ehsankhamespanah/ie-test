package ir.ac.ut.ece.ie.servlets;


import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ir.ac.ut.ece.ie.repository.FlightRepository;


@WebServlet("/book")
public class BookFlight  extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
        		"<link rel=\"stylesheet\"\n" + 
        		"	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" + 
        		"<script\n" + 
        		"	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" + 
        		"<script\n" + 
        		"	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n" + 
        		"");
        out.println("<title>Booking Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("	<nav class=\"navbar navbar-inverse\">\n" + 
        		"		<div class=\"container-fluid\">\n" + 
        		"			<div class=\"navbar-header\">\n" + 
        		"				<a class=\"navbar-brand\" href=\"#\">UTAIR</a>\n" + 
        		"			</div>\n" + 
        		"			<ul class=\"nav navbar-nav\">\n" + 
        		"				<li class=\"active\"><a href=\"#\">Home</a></li>\n" + 
        		"				<li class=\"dropdown\"><a class=\"dropdown-toggle\"\n" + 
        		"					data-toggle=\"dropdown\" href=\"#\">Today <span class=\"caret\"></span></a>\n" + 
        		"					<ul class=\"dropdown-menu\">\n" + 
        		"						<li><a href=\"#\">All</a></li>\n" + 
        		"						<li><a href=\"#\">Arrival</a></li>\n" + 
        		"						<li><a href=\"#\">Departure</a></li>\n" + 
        		"					</ul></li>\n" + 
        		"				<li><a href=\"#\">Book</a></li>\n" + 
        		"			</ul>\n" + 
        		"			<ul class=\"nav navbar-nav navbar-right\">\n" + 
        		"				<li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span>\n" + 
        		"						Sign Up</a></li>\n" + 
        		"				<li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span>\n" + 
        		"						Login</a></li>\n" + 
        		"			</ul>\n" + 
        		"		</div>\n" + 
        		"	</nav>\n" + 
        		"");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String destination = request.getParameter("destination");
        String numberOfTickets = request.getParameter("numberOfTickets");
        out.println("<h1>The flight is booked successfully!</h1>");
        out.println("In flight to " + destination + ", " + 
        		numberOfTickets + " seats are reserved for " + firstName + " " + lastName + ".");
        FlightRepository.getInstance().updateAvailableSeats(destination, Integer.parseInt(numberOfTickets));
        out.println("<form action=\"index.html\"><div class=\"col-md-12 text-center\"> \n" + 
		"    <button type=\"submit\" class=\"btn btn-primary\" >Home</button>\n" + 
		"</div></form>\n");
        out.println("</body>");
        out.println("</html>");
	}
}
