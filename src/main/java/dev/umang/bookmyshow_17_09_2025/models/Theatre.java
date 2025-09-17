package dev.umang.bookmyshow_17_09_2025.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    private String location;
    private List<Screen> screens;
}
