package ru.stepanov.democrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepanov.democrud.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
