package dev.umang.bookmyshow_17_09_2025.models;

import dev.umang.bookmyshow_17_09_2025.models.enums.Feature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private Movie movie;
    private Long startTime;
    private Long endTime;
    private Screen screen;
    private List<Feature> features;
}
