package dev.umang.bookmyshow_17_09_2025.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String description;
    private int duration; // in minutes
    private String language;
    private String genre;
    private double rating; // average rating
}
