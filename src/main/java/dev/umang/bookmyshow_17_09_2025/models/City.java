package dev.umang.bookmyshow_17_09_2025.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel{
    private String name;
    private String state;
    private List<Theatre> theatres;
}
