package kh.edu.istad.todobackend.features.user;

import jakarta.validation.Valid;
import kh.edu.istad.todobackend.features.user.dto.UserCreateRequest;
import kh.edu.istad.todobackend.features.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

//    create user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserResponse createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        return userService.createUser(userCreateRequest);
    }

//    get all users
    @GetMapping
    List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

//    get user by their username
    @GetMapping("/username/{username}")
    UserResponse getUserByUsername(@Valid @PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }
}
