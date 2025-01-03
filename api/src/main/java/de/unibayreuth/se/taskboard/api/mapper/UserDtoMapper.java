package de.unibayreuth.se.taskboard.api.mapper;

import de.unibayreuth.se.taskboard.api.dtos.TaskDto;
import de.unibayreuth.se.taskboard.api.dtos.UserDto;
import de.unibayreuth.se.taskboard.business.domain.Task;
import de.unibayreuth.se.taskboard.business.domain.User;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Mapper(componentModel = "spring")
@ConditionalOnMissingBean // prevent IntelliJ warning about duplicate beans
@NoArgsConstructor
public abstract class UserDtoMapper {

        @Mapping(target = "assignee", ignore = true)
        public abstract UserDto fromBusiness(User source);

        //@Mapping(target = "assigneeId", source = "assignee.id")
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "createdAt", expression = "java(mapTimestamp(source.getCreatedAt()))")
        @Mapping(target = "updatedAt", expression = "java(mapTimestamp(source.getUpdatedAt()))")
        public abstract User toBusiness(UserDto source);

        protected UserDto getUserById(UUID userId) {
//        if (userId == null) {
//            return null;
//        }
//        return userService.getById(userId).map(userDtoMapper::fromBusiness).orElse(null);
            return null;
        }
}
