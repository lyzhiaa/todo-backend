package kh.edu.istad.todobackend.features.user;

import kh.edu.istad.todobackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
//    check if username is already exist
    Boolean existsByUsername(String username);
//    find user by username
    Optional<User> findByUsername(String username);
}
