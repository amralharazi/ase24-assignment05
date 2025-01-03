package de.unibayreuth.se.taskboard.api.dtos;

import de.unibayreuth.se.taskboard.business.domain.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

//TODO: Add DTO for users.
@RequiredArgsConstructor
public class UserDto {
    @NotNull
    private final UUID id; 
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
}
