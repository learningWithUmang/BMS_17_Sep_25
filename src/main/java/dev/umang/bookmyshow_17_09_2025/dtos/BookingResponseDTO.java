package dev.umang.bookmyshow_17_09_2025.dtos;

import dev.umang.bookmyshow_17_09_2025.models.Booking;
import lombok.Getter;
import lombok.Setter;


public class BookingResponseDTO {
    private Booking booking;
    private ResponseStatus responseStatus;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
