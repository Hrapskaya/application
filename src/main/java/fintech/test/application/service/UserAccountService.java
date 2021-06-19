package fintech.test.application.service;

import fintech.test.application.dto.UserAccountDto;
import org.springframework.data.domain.Page;

public interface UserAccountService {

    UserAccountDto save(UserAccountDto userAccountDto);

    void update(UserAccountDto userAccountDto);

    void changeStatus(UserAccountDto userAccountDto);

    UserAccountDto findById(Integer id);

    Page<UserAccountDto> findPage(int page);
}
