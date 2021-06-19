package fintech.test.application.service.impl;

import fintech.test.application.converter.UserAccountConverter;
import fintech.test.application.dto.UserAccountDto;
import fintech.test.application.entity.UserAccount;
import fintech.test.application.repository.UserAccountRepository;
import fintech.test.application.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DefaultUserAccountService implements UserAccountService {

    public static final int MAX_USER_ACCOUNT_ON_PAGE = 4;

    private final UserAccountRepository userAccountRepository;


    @Override
    public UserAccountDto save(UserAccountDto userAccountDto) {
        UserAccount newUserAccount= UserAccountConverter.fromDto(userAccountDto);
        UserAccount savedUserAccount = userAccountRepository.save(newUserAccount);
        return UserAccountConverter.toDto(savedUserAccount);
    }

    @Override
    public void update(UserAccountDto userAccountDto) {

    }

    @Override
    public void changeStatus(UserAccountDto userAccountDto) {

    }

    @Override
    public UserAccountDto findById(Integer id) {
        Optional<UserAccount> userAccount = userAccountRepository.findById(id);
        UserAccountDto userAccountDto = null;
        if(userAccount.isPresent()){
            userAccountDto = UserAccountConverter.toDto(userAccount.get());
        }
        return userAccountDto;
    }

    @Override
    public Page<UserAccountDto> findPage(int page) {
        Page<UserAccount> userAccountPage = userAccountRepository.findAll(PageRequest.of(page, MAX_USER_ACCOUNT_ON_PAGE, Sort.by("id")));
        return userAccountPage.map(UserAccountConverter::toDto);
    }
}
