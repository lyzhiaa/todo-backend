package kh.edu.istad.todobackend.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String uuid;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
