package dev.umang.bookmyshow_17_09_2025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    private String location;

    @OneToMany
    private List<Screen> screens;
}
/*
1       M
1        1
Theatre Screen
 */
