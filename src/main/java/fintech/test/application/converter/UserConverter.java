package fintech.test.application.converter;

import fintech.test.application.dto.User;
import fintech.test.application.entity.UserAccount;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public static UserAccount toEntity(User user) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(user.getId());
        userAccount.setUserName(user.getUsername());
        userAccount.setPassword(user.getPassword());
        userAccount.setFirstName(user.getFirstName());
        userAccount.setLastName(user.getLastName());
        userAccount.setRole(user.getRole());
        userAccount.setStatus(user.getStatus());
        userAccount.setCreatedAt(user.getCreatedAt());
        return userAccount;
    }

    public static User fromEntity(UserAccount userAccount) {
        User user = new User();
        user.setId(userAccount.getId());
        user.setUserName(userAccount.getUserName());
        user.setPassword(userAccount.getPassword());
        user.setFirstName(userAccount.getFirstName());
        user.setLastName(userAccount.getLastName());
        user.setRole(userAccount.getRole());
        user.setStatus(userAccount.getStatus());
        user.setCreatedAt(userAccount.getCreatedAt());
        return user;
    }
}
