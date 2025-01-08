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

        public abstract UserDto fromBusiness(User source);
        protected boolean utcNowUpdated = false;
        protected LocalDateTime utcNow;
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "createdAt", expression = "java(mapTimestamp(source.getCreatedAt()))")
        public abstract User toBusiness(UserDto source);

        protected LocalDateTime mapTimestamp (LocalDateTime timestamp) {
                if (timestamp == null) {
                        // ensure that createdAt and updatedAt use exactly the same timestamp
                        if (!utcNowUpdated) {
                                utcNow = LocalDateTime.now(ZoneId.of("UTC"));
                                utcNowUpdated = true;
                        } else {
                                utcNowUpdated = false;
                        }
                        return utcNow;
                }
                return timestamp;
        }
}
