package kh.edu.istad.todobackend.mapper;

import kh.edu.istad.todobackend.domain.User;
import kh.edu.istad.todobackend.features.user.dto.UserCreateRequest;
import kh.edu.istad.todobackend.features.user.dto.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    create user request to user entity
    User fromUserCreateRequest(UserCreateRequest userCreateRequest);
//    get single user by find user by username
    UserResponse toUserResponse(User user);
//    get all users
    List<UserResponse> toUserResponseList(List<User> users);
}
