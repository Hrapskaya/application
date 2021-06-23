package fintech.test.application.service.impl;

import fintech.test.application.domain.entity.UserAccountEntity;
import fintech.test.application.domain.UserAccount;
import fintech.test.application.domain.UserStatus;
import fintech.test.application.repository.UserAccountRepository;
import fintech.test.application.service.UserAccountService;
import fintech.test.application.service.UserAccountSpecification;
import fintech.test.application.service.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class DefaultUserAccountService implements UserAccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAccountRepository userAccountRepository;


    @Override
    public UserAccount add(UserAccount userAccount) {
        UserAccountEntity userAccountEntityFromBd = userAccountRepository.findByUsername(userAccount.getUsername());
        if (userAccountEntityFromBd == null) {
            UserAccountEntity newUserAccountEntity = UserConverter.toEntity(userAccount);
            newUserAccountEntity.setPassword(passwordEncoder.encode(userAccount.getPassword()));
            UserAccountEntity savedUserAccountEntity = userAccountRepository.save(newUserAccountEntity);
            userAccount.setId(savedUserAccountEntity.getId());
            return userAccount;
        } else {
            return null;
        }
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        UserAccountEntity userAccountEntity = userAccountRepository.findByUsername(userAccount.getUsername());
        if (userAccountEntity == null) {
            return null;
        } else {
            userAccountEntity.setFirstName(userAccount.getFirstName());
            userAccountEntity.setLastName(userAccount.getLastName());
            userAccountEntity.setRole(userAccount.getRole());
            userAccountEntity.setStatus(userAccount.getStatus());
            userAccountRepository.save(userAccountEntity);
            return UserConverter.fromEntity(userAccountEntity);
        }
    }

    @Override
    public boolean updatePassword(UserAccount userAccount) {
        UserAccountEntity userAccountEntity = userAccountRepository.findByUsername(userAccount.getUsername());
        if (userAccountEntity != null) {
            userAccountEntity.setPassword(passwordEncoder.encode(userAccount.getPassword()));
            userAccountRepository.save(userAccountEntity);
            return true;
        }
        return false;
    }

    @Override
    public UserAccount changeStatus(Integer id) {
        UserAccountEntity userAccountEntityFromBd = userAccountRepository.findById(id).orElse(null);
        if (userAccountEntityFromBd == null) {
            return null;
        } else {
            UserStatus userStatusInBd = userAccountEntityFromBd.getStatus();
            UserStatus newUserStatus = userStatusInBd == UserStatus.ACTIVE ? UserStatus.INACTIVE : UserStatus.ACTIVE;
            userAccountEntityFromBd.setStatus(newUserStatus);
            userAccountRepository.save(userAccountEntityFromBd);
            return UserConverter.fromEntity(userAccountEntityFromBd);
        }
    }

    @Override
    public UserAccount findById(Integer id) {
        Optional<UserAccountEntity> userAccount = userAccountRepository.findById(id);
        UserAccount user = null;
        if (userAccount.isPresent()) {
            user = UserConverter.fromEntity(userAccount.get());
        }
        return user;
    }

    @Override
    public Page<UserAccount> findPage(Pageable pageable) {
        Page<UserAccountEntity> userAccountPage = userAccountRepository.findAll(pageable);
        return userAccountPage.map(UserConverter::fromEntity);
    }

    @Override
    public Page<UserAccount> findPage(String filterUsername, String filterUserRole, Pageable pageable) {
        Specification<UserAccountEntity> specification =
                new UserAccountSpecification(filterUsername, filterUserRole, pageable);
        Page<UserAccountEntity> userAccountEntityPage = userAccountRepository.findAll( specification, pageable);
        return userAccountEntityPage.map(UserConverter::fromEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountEntity userAccountEntity = userAccountRepository.findByUsername(username);
        if (userAccountEntity == null) {
            return null;
        }
        UserAccount userAccount = UserConverter.fromEntity(userAccountEntity);
        userAccount.setPassword(userAccountEntity.getPassword());
        return userAccount;
    }
}
