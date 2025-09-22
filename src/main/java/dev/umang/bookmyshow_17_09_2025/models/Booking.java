package dev.umang.bookmyshow_17_09_2025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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