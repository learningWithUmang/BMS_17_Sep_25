package dev.umang.bookmyshow_17_09_2025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel{
    private String name;
    private String state;

    @OneToMany
    private List<Theatre> theatres;
}
