package fintech.test.application.service.impl;

import fintech.test.application.converter.UserConverter;
import fintech.test.application.dto.User;
import fintech.test.application.entity.UserAccount;
import fintech.test.application.repository.UserRepository;
import fintech.test.application.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService {

    public static final int MAX_USER_ACCOUNT_ON_PAGE = 4;

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public boolean add(User user) {
        boolean result = false;
        UserAccount userAccountFromBd = userRepository.findByUserName(user.getUsername());
        if (userAccountFromBd == null) {
            UserAccount newUserAccount = UserConverter.toEntity(user);
            newUserAccount.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(newUserAccount);
            result = true;
        }
        return result;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void changeStatus(User user) {

    }

    @Override
    public User findById(Integer id) {
        Optional<UserAccount> userAccount = userRepository.findById(id);
        User user = null;
        if (userAccount.isPresent()) {
            user = UserConverter.fromEntity(userAccount.get());
        }
        return user;
    }

    @Override
    public Page<User> findPage(int page) {
        Page<UserAccount> userAccountPage = userRepository.findAll(PageRequest.of(page, MAX_USER_ACCOUNT_ON_PAGE, Sort.by("id")));
        return userAccountPage.map(UserConverter::fromEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userRepository.findByUserName(username);
        return  UserConverter.fromEntity(userAccount);
    }
}
