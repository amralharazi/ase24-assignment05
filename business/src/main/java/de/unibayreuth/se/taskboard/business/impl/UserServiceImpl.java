package de.unibayreuth.se.taskboard.business.impl;

import de.unibayreuth.se.taskboard.business.domain.Task;
import de.unibayreuth.se.taskboard.business.domain.User;
import de.unibayreuth.se.taskboard.business.exceptions.MalformedRequestException;
import de.unibayreuth.se.taskboard.business.exceptions.TaskNotFoundException;
import de.unibayreuth.se.taskboard.business.exceptions.UserNotFoundException;
import de.unibayreuth.se.taskboard.business.ports.UserPersistenceService;
import de.unibayreuth.se.taskboard.business.ports.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPersistenceService userPersistenceService;

    @Override
    public void clear() {
        userPersistenceService.clear();
    }

    @Override
    @NonNull
    public User create(User user) throws MalformedRequestException {
        if (user.getId() != null) {
            throw new MalformedRequestException("User ID must not be set.");
        }
        return upsert(user);
    }

    @Override
    @NonNull
    public List<User> getAll() { return userPersistenceService.getAll(); }

    @Override
    @NonNull
    public User getById(@NonNull UUID id) throws UserNotFoundException {
        return userPersistenceService.getById(id)
                .orElseThrow(() -> new TaskNotFoundException("User with ID " + id + " does not exist."));
    }

    @Override
    @NonNull
    public User upsert(@NonNull User user) throws UserNotFoundException {
        return userPersistenceService.upsert(user);
    }
}
