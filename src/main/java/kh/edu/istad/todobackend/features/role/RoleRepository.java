package kh.edu.istad.todobackend.features.role;


import kh.edu.istad.todobackend.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Boolean existsByName(String name);
    Optional<Role> findByUuid(String uuid);
}
