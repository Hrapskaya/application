package fintech.test.application.converter;

import fintech.test.application.dto.User;
import fintech.test.application.entity.UserAccount;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public static UserAccount fromDto(User user) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(user.getId());
        userAccount.setUserName(user.getUserName());
        userAccount.setPassword(user.getPassword());
        userAccount.setFirstName(user.getFirstName());
        userAccount.setLastName(user.getLastName());
        userAccount.setRole(user.getRole());
        userAccount.setStatus(user.getStatus());
        userAccount.setCreatedAt(user.getCreatedAt());
        return userAccount;
    }

    public static User toDto(UserAccount userAccount) {
        return User.builder()
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
