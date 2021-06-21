package fintech.test.application.service.impl;

import fintech.test.application.model.UserStatus;
import fintech.test.application.service.UserConverter;
import fintech.test.application.entity.UserAccountEntity;
import fintech.test.application.model.UserAccount;
import fintech.test.application.repository.UserAccountRepository;
import fintech.test.application.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DefaultUserAccountService implements UserAccountService {

    private final PasswordEncoder passwordEncoder;
    private final UserAccountRepository userAccountRepository;

    @Override
    public UserAccount add(UserAccount userAccount) {
        UserAccountEntity userAccountEntityFromBd = userAccountRepository.findByUserName(userAccount.getUsername());
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
    public void update(UserAccount userAccount) {

    }

    @Override
    public UserAccount changeStatus(Integer id) {
        UserAccountEntity userAccountEntityFromBd = userAccountRepository.findById(id).orElse(null);
        if(userAccountEntityFromBd == null){
            return null;
        }else {
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountEntity userAccountEntity = userAccountRepository.findByUserName(username);
        return UserConverter.fromEntity(userAccountEntity);
    }
}
