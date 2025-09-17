package dev.umang.bookmyshow_17_09_2025.models;


import dev.umang.bookmyshow_17_09_2025.models.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    private Show show;
    private Seat seat;
    private Long price;
    private ShowSeatStatus showSeatStatus;
}
