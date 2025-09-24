package dev.umang.bookmyshow_17_09_2025.models;

import dev.umang.bookmyshow_17_09_2025.models.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<ShowSeat> showSeats;

    private Long amount;

    @OneToMany
    private List<Transaction> payments;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public List<Transaction> getPayments() {
        return payments;
    }

    public void setPayments(List<Transaction> payments) {
        this.payments = payments;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
/*
1          M
M          1
Booking ShowSeat = > M : M
booking = 4:30 PM show Conjuring seat_no = 1,2,3 ,  booking_id = 90
bookings that 1,2
cancel the booking
booking = 4:30 PM show conjuring seat_no = 1,2,6, booking_id = 91
1      1
M       1
Booking User => M : 1
 */
/*
class A {
    B b;
}
Relation??
You need to annoated all the relations

1        1
Booking Show => M : 1
M         1
 */