package ir.ac.ut.ece.ie.controller;

import ir.ac.ut.ece.ie.model.BookingRequest;
import ir.ac.ut.ece.ie.model.BookingResponse;
import ir.ac.ut.ece.ie.model.Flight;
import ir.ac.ut.ece.ie.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> listFlights() {
        return flightService.getFlights();
    }

    @PostMapping("/book")
    public BookingResponse book(@Valid @RequestBody BookingRequest request) {
        return flightService.book(request);
    }
}
