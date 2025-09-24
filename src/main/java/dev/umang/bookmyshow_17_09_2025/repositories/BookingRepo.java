package dev.umang.bookmyshow_17_09_2025.repositories;

import dev.umang.bookmyshow_17_09_2025.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
