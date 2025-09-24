package dev.umang.bookmyshow_17_09_2025.repositories;

import dev.umang.bookmyshow_17_09_2025.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /*
    JPARepository
    gives you a bunch of inbuilt methods that you
    can directly call by extending it for your model

     */
}
