package dev.umang.bookmyshow_17_09_2025.controllers;

import dev.umang.bookmyshow_17_09_2025.dtos.BookingRequestDTO;
import dev.umang.bookmyshow_17_09_2025.dtos.BookingResponseDTO;
import dev.umang.bookmyshow_17_09_2025.dtos.ResponseStatus;
import dev.umang.bookmyshow_17_09_2025.models.Booking;
import dev.umang.bookmyshow_17_09_2025.services.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    /*
    bookTicket
    input output
    HTTP method is going to be used to define type of action API is performing
    GET, PUT, POST, PATCH, DELETE
     */

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookTicket")
    BookingResponseDTO bookTicket(@RequestBody BookingRequestDTO bookingRequestDTO){
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();

        try {
            Booking booking = bookingService.bookTicket(bookingRequestDTO.getUserId(),
                    bookingRequestDTO.getShowId(),
                    bookingRequestDTO.getShowSeatsIds());
            bookingResponseDTO.setBooking(booking);
            bookingResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            bookingResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }

        return bookingResponseDTO;
    }
}
/*
Idempotency
 */
