package fintech.test.application.service;

import fintech.test.application.domain.UserAccount;
import fintech.test.application.domain.entity.UserAccountEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public static UserAccountEntity toEntity(UserAccount userAccount) {
        UserAccountEntity userAccountEntity = new UserAccountEntity();
        userAccountEntity.setId(userAccount.getId());
        userAccountEntity.setUsername(userAccount.getUsername());
        userAccountEntity.setFirstName(userAccount.getFirstName());
        userAccountEntity.setLastName(userAccount.getLastName());
        userAccountEntity.setRole(userAccount.getRole());
        userAccountEntity.setStatus(userAccount.getStatus());
        userAccountEntity.setCreatedAt(userAccount.getCreatedAt());
        return userAccountEntity;
    }

    public static UserAccount fromEntity(UserAccountEntity userAccountEntity) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(userAccountEntity.getId());
        userAccount.setUsername(userAccountEntity.getUsername());
        userAccount.setFirstName(userAccountEntity.getFirstName());
        userAccount.setLastName(userAccountEntity.getLastName());
        userAccount.setRole(userAccountEntity.getRole());
        userAccount.setStatus(userAccountEntity.getStatus());
        userAccount.setCreatedAt(userAccountEntity.getCreatedAt());
        return userAccount;
    }
}
