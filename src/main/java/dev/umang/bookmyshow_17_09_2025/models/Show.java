package dev.umang.bookmyshow_17_09_2025.models;

import dev.umang.bookmyshow_17_09_2025.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;

    private Long startTime;
    private Long endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
/*
Show Movie
1     1
M       1
ORMs for working with db
MySQL DB to persist all the data
Object Relational mapping = Hibernate

 */