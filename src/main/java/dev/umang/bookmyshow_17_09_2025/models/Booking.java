package dev.umang.bookmyshow_17_09_2025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private Show show;
    private User user;
    private List<ShowSeat> showSeats;
    private Long amount;
    private List<Transaction> payments;
}
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