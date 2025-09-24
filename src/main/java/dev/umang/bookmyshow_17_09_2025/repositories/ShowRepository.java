package dev.umang.bookmyshow_17_09_2025.repositories;

import dev.umang.bookmyshow_17_09_2025.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {

}
