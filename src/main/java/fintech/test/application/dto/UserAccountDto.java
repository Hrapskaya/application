package fintech.test.application.dto;

import fintech.test.application.entity.UserRole;
import fintech.test.application.entity.UserStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserAccountDto {

    private Integer id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private UserRole role;

    private UserStatus status;

    private LocalDate createdAt;
}
