package kh.edu.istad.todobackend.features.user.dto;

import java.time.LocalDateTime;

public record UserResponse(
        String uuid,
        String username,
        String firstName,
        String lastName,
        String email,
        String profileImage,
        String bio,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
