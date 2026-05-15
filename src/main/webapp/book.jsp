<%@page import="ir.ac.ut.ece.ie.repository.FlightRepository"%>
<jsp:include page="header.jsp" />

<%
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String destination = request.getParameter("destination");
	String numberOfTickets = request.getParameter("numberOfTickets");
%>
<h1>The flight is booked successfully!</h1>
In flight to
<%=destination%>,
<%=numberOfTickets%>
seats are reserved for
<%=firstName%>
<%=lastName%>.
<%
	FlightRepository.getInstance().updateAvailableSeats(destination, Integer.parseInt(numberOfTickets));
%>
<form action="index.jsp">
	<div class="col-md-12 text-center">
		<button type="submit" class="btn btn-primary">Home</button>
	</div>
</form>

<jsp:include page="footer.jsp" />
