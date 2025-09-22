package dev.umang.bookmyshow_17_09_2025.models;


import dev.umang.bookmyshow_17_09_2025.models.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;
    private Long price;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}
/*
ShowSeat Show
(show, seat) (show) = > M : 1
1          1
M           1

AB :  A / B => M : 1
 */
