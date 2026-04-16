package kh.edu.istad.todobackend.features.user;

import kh.edu.istad.todobackend.features.user.dto.UserCreateRequest;
import kh.edu.istad.todobackend.features.user.dto.UserResponse;

import java.util.List;

public interface UserService {
//    create user
    UserResponse createUser(UserCreateRequest userCreateRequest);
//    get all users
    List<UserResponse> getAllUsers();
//    get single user
    UserResponse getUserByUsername(String username);
}
