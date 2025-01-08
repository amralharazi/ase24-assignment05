package de.unibayreuth.se.taskboard.api.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

//TODO: Add DTO for users.
@Data
public class UserDto {
    @Nullable
    private final UUID id;
    @NotNull
    private final String name;
    @Nullable
    private final LocalDateTime createdAt; // is null when using DTO to create or update a new user

    public LocalDateTime getCreatedAt() {
        return Objects.requireNonNullElseGet(createdAt, LocalDateTime::now);
    }
}
