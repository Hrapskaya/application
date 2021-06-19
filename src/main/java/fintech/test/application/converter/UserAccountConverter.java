package fintech.test.application.converter;

import fintech.test.application.dto.UserAccountDto;
import fintech.test.application.entity.UserAccount;
import org.springframework.stereotype.Component;

@Component
public class UserAccountConverter {

    public UserAccount toEntity(UserAccountDto userAccountDto) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(userAccountDto.getId());
        userAccount.setUserName(userAccountDto.getUserName());
        userAccount.setPassword(userAccountDto.getPassword());
        userAccount.setFirstName(userAccountDto.getFirstName());
        userAccount.setLastName(userAccountDto.getLastName());
        userAccount.setRole(userAccountDto.getRole());
        userAccount.setStatus(userAccountDto.getStatus());
        userAccount.setCreatedAt(userAccountDto.getCreatedAt());
        return userAccount;
    }

    public UserAccountDto fromEntity(UserAccount userAccount) {
        return UserAccountDto.builder()
                .id(userAccount.getId())
                .userName(userAccount.getUserName())
                .password(userAccount.getPassword())
                .firstName(userAccount.getFirstName())
                .lastName(userAccount.getLastName())
                .role(userAccount.getRole())
                .status(userAccount.getStatus())
                .createdAt(userAccount.getCreatedAt()).build();
    }
}
