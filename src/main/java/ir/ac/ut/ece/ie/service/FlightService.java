package ir.ac.ut.ece.ie.service;

import ir.ac.ut.ece.ie.model.BookingRequest;
import ir.ac.ut.ece.ie.model.BookingResponse;
import ir.ac.ut.ece.ie.model.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FlightService {
    private final Map<String, Integer> inventory = new ConcurrentHashMap<>();

    public FlightService() {
        inventory.put("Beijing", 165);
        inventory.put("Toronto", 70);
        inventory.put("Barcelona", 66);
        inventory.put("Paris", 27);
    }

    public List<Flight> getFlights() {
        return inventory.entrySet().stream()
                .map(entry -> new Flight(entry.getKey(), entry.getValue()))
                .toList();
    }

    public BookingResponse book(BookingRequest request) {
        Integer available = inventory.get(request.destination());
        if (available == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Destination not found");
        }
        if (available < request.numberOfTickets()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough seats available");
        }

        int remaining = available - request.numberOfTickets();
        inventory.put(request.destination(), remaining);

        String message = "%d seats reserved to %s %s for %s."
                .formatted(request.numberOfTickets(), request.firstName(), request.lastName(), request.destination());
        return new BookingResponse(message, remaining);
    }
}
