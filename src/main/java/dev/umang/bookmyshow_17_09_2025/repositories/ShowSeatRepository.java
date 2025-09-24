package dev.umang.bookmyshow_17_09_2025.repositories;

import dev.umang.bookmyshow_17_09_2025.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    /*
    2 requests call this method at the same time, both the requests
    will get list of show seats
    what if whenever i give a list of show seats to one request, i don't give
    any common seat to another request?

     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    /*
    We are reading the showSeats to pesssismisctially update them in future

     */
    @Query("SELECT ss FROM ShowSeat ss WHERE ss.id IN :showSeatIds")
    List<ShowSeat> findAllById(List<Long> showSeatIds);
}
/*
Read about types of lock
Read about isolation levels in SQL DBs
 */