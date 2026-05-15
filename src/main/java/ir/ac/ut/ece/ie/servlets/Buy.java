package ir.ac.ut.ece.ie.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ir.ac.ut.ece.ie.repository.FlightRepository;

public class Buy extends HttpServlet {
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
        out.println("<title>Passenger Info</title>");
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
        String destination = request.getParameter("destination");
		out.println("<div class=\"container\"><form action=\"book\">\n" + 
        		"  <div class=\"form-group col-md-8\">\n" + 
        		"    <label>Destination</label>\n" + 
        		"    <input type=\"text\" readonly class=\"form-control\" name=\"destination\" value=\"" + destination + "\">\n" + 
        		"  </div>\n" + 
        		"  <div class=\"form-group col-md-4\">\n" + 
        		"    <label>Available Seats</label>\n" + 
        		"    <input type=\"text\" readonly class=\"form-control\" id=\"availableSeats\" value=\"" + FlightRepository.getInstance().getAvailableSeats(destination) + "\">\n" + 
        		"  </div>\n" + 
        		"    <div class=\"form-row\">\n" + 
        		"    <div class=\"form-group col-md-6\">\n" + 
        		"      <label>First Name</label>\n" + 
        		"      <input type=\"text\" class=\"form-control\" name=\"firstName\" placeholder=\"First Name\">\n" + 
        		"    </div>\n" + 
        		"    <div class=\"form-group col-md-6\">\n" + 
        		"      <label>LastName</label>\n" + 
        		"      <input type=\"text\" class=\"form-control\" name=\"lastName\" placeholder=\"Last Name\">\n" + 
        		"    </div>\n" + 
        		"  </div>" + 
        		"  <div class=\"form-group col-md-2\">\n" + 
        		"    <label for=\"exampleFormControlSelect1\">Number Of Tickets</label>\n" + 
        		"    <select class=\"form-control\" name=\"numberOfTickets\">\n" + 
        		"      <option>1</option>\n" + 
        		"      <option>2</option>\n" + 
        		"      <option>3</option>\n" + 
        		"      <option>4</option>\n" + 
        		"      <option>5</option>\n" + 
        		"    </select>\n" + 
        		"  </div>\n" +
        		"<div class=\"col-md-12 text-center\"> \n" + 
        		"    <button type=\"submit\" class=\"btn btn-primary\" >Book</button>\n" + 
        		"</div>\n" + 
        		"</form>");
        out.println("</div></body>");
        out.println("</html>");
	}
}
