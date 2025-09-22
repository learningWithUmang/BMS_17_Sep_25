package dev.umang.bookmyshow_17_09_2025.models;

import dev.umang.bookmyshow_17_09_2025.models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel{
    private String seatNumber;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
