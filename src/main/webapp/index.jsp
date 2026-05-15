<%@page import="ir.ac.ut.ece.ie.repository.FlightRepository"%>

<jsp:include page="header.jsp" />

<div class="container">
	<div id="fdw-pricing-table">
		<div class="plan plan1">
			<div class="header">Beijing</div>
			<div class="price">$59</div>
			<div class="monthly">Round Trip</div>
			<ul>
				<li>Dinner and Breakfast</li>
				<li>Available Seats: <%=FlightRepository.getInstance().getAvailableSeats("Beijing")%></li>
			</ul>
			<a class="signup" href="buy.jsp?destination=Beijing">Buy</a>
		</div>
		<div class="plan plan2 popular-plan">
			<div class="header">Toronto</div>
			<div class="price">$890</div>
			<div class="monthly">Round Trip</div>
			<ul>
				<li>Breakfast, Lunch, and Dinner</li>
				<li>Available Seats: <%=FlightRepository.getInstance().getAvailableSeats("Toronto")%></li>
			</ul>
			<a class="signup" href="buy.jsp?destination=Toronto">Buy</a>
		</div>
		<div class="plan plan3">
			<div class="header">Barcelona</div>
			<div class="price">$275</div>
			<div class="monthly">Round Trip</div>
			<ul>
				<li>Dinner and Breakfast</li>
				<li>Available Seats: <%=FlightRepository.getInstance().getAvailableSeats("Barcelona")%></li>
			</ul>
			<a class="signup" href="buy.jsp?destination=Barcelona">Buy</a>
		</div>
		<div class="plan plan4">
			<div class="header">Paris</div>
			<div class="price">$325</div>
			<div class="monthly">Round Trip</div>
			<ul>
				<li>Breakfast and Lunch</li>
				<li>Available Seats: <%=FlightRepository.getInstance().getAvailableSeats("Paris")%></li>
			</ul>
			<a class="signup" href="buy.jsp?destination=Paris">Buy</a>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />