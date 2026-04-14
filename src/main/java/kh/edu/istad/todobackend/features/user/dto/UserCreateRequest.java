package kh.edu.istad.todobackend.features.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
        @NotBlank(message = "username is require!!!")
        @Size(max = 50, message = "Username must not exceed 50 characters")
        String username,
        @NotBlank(message = "FirstName is require!!!")
        @Size(max = 50, message = "FirstName must not exceed 50 characters")
        String firstName,
        @NotBlank(message = "LastName is require!!!")
        @Size(max = 50, message = "LastName must not exceed 50 characters")
        String lastName,
        @NotBlank(message = "Email is required")
        @Email(message = "This email is invalid")
        String email,
        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password
) {
}
