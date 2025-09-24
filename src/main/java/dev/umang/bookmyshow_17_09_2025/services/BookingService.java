package dev.umang.bookmyshow_17_09_2025.services;

import dev.umang.bookmyshow_17_09_2025.exceptions.UserNotFoundException;
import dev.umang.bookmyshow_17_09_2025.models.Booking;
import dev.umang.bookmyshow_17_09_2025.models.Show;
import dev.umang.bookmyshow_17_09_2025.models.ShowSeat;
import dev.umang.bookmyshow_17_09_2025.models.User;
import dev.umang.bookmyshow_17_09_2025.models.enums.BookingStatus;
import dev.umang.bookmyshow_17_09_2025.models.enums.ShowSeatStatus;
import dev.umang.bookmyshow_17_09_2025.repositories.BookingRepo;
import dev.umang.bookmyshow_17_09_2025.repositories.ShowRepository;
import dev.umang.bookmyshow_17_09_2025.repositories.ShowSeatRepository;
import dev.umang.bookmyshow_17_09_2025.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PaymentService paymentService;
    private BookingRepo bookingRepo;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PaymentService paymentService,
                          BookingRepo bookingRepo){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.paymentService = paymentService;
        this.bookingRepo = bookingRepo;
    }
    /*
    can multiple requests come to book the same seat at the same time?
     */


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userId,
                              Long showId,
                              List<Long> showSeatIds){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User not found");
        }

        Optional<Show> optionalShow = showRepository.findById(showId);

        if(optionalShow.isEmpty()){
            throw new RuntimeException("Show not found");
        }

        User user = optionalUser.get();
        Show show = optionalShow.get();

        /*
        This is exactly the meat of the implementation
         */

        /*
        T1
        T2
         */
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        if(showSeatIds.size() != showSeats.size()){
            throw new RuntimeException("Some seats are not found");
        }
        /*

         */

        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("Seats are no longer available");
            }
        }

        /*

         */
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(showSeats);

        Long amount = 0L;
        for(ShowSeat showSeat: showSeats){
            amount = amount + showSeat.getPrice();
        }

        booking.setAmount(amount); // imagine price calculation is a seaparate logic

        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
        }

        showSeatRepository.saveAll(showSeats); // db call to block all these show seats in db
        /*
        sql query behind the scenes to showSeat table
        transactional
         */

        /*
         bug in these lines of code
         */

        /*
        You are 3P party api call to initiate and do the txn
        can take 5-10 min
         */

        boolean paymentStatus = paymentService.initiatePayment();
        /*
        Payment is success
        Payment is failure

         */

        if(paymentStatus == true){
            for(ShowSeat showSeat: showSeats){
                showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            }
            showSeatRepository.saveAll(showSeats);
            booking.setBookingStatus(BookingStatus.CONFIRMED);
        }else{
            for(ShowSeat showSeat: showSeats){
                showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            }
            showSeatRepository.saveAll(showSeats);
            booking.setBookingStatus(BookingStatus.FAILED);
        }

        bookingRepo.save(booking);
        return booking;
    }
}
/*
This whole logic should be transactional in nature
 */
