package dev.umang.bookmyshow_17_09_2025.models;


import dev.umang.bookmyshow_17_09_2025.models.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;
    private Long price;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public ShowSeatStatus getShowSeatStatus() {
        return showSeatStatus;
    }

    public void setShowSeatStatus(ShowSeatStatus showSeatStatus) {
        this.showSeatStatus = showSeatStatus;
    }
}
/*
ShowSeat Show
(show, seat) (show) = > M : 1
1          1
M           1

AB :  A / B => M : 1
 */
