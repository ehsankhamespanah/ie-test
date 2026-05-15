package ir.ac.ut.ece.ie.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record BookingRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String destination,
        @Min(1) @Max(5) int numberOfTickets
) {
}
