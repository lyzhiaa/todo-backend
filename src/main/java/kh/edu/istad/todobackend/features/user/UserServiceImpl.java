package kh.edu.istad.todobackend.features.user;

import kh.edu.istad.todobackend.domain.User;
import kh.edu.istad.todobackend.features.user.dto.UserCreateRequest;
import kh.edu.istad.todobackend.features.user.dto.UserResponse;
import kh.edu.istad.todobackend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
//    create user
    @Override
    public UserResponse createUser(UserCreateRequest userCreateRequest) {
//        check if user the username is already exist
        if (userRepository.existsByUsername(userCreateRequest.username())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "The user with this username already exists");
        }

        User user = userMapper.fromUserCreateRequest(userCreateRequest);
        user.setUuid(UUID.randomUUID().toString());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setDisabled(false);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

//    get all users
    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toUserResponseList(users);
    }

//    get user by their username
    @Override
    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "User with username '" + username + "' does not exist"));
        return userMapper.toUserResponse(user);
    }
}
