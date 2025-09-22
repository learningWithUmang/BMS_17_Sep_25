package dev.umang.bookmyshow_17_09_2025.models;

import dev.umang.bookmyshow_17_09_2025.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;

    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    private String layoutSnapshot; //in form of urls
}

/*
Screen seat

 */
