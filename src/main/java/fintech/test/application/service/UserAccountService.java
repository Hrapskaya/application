package fintech.test.application.service;

import fintech.test.application.model.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserAccountService extends UserDetailsService {

    UserAccount add(UserAccount userAccount);

    UserAccount update(UserAccount userAccount);

    UserAccount changeStatus(Integer id);

    UserAccount findById(Integer id);

    Page<UserAccount> findPage(Pageable pageable);

    Page<UserAccount> findPage(String filterUserName, String filterUserRole, Pageable pageable);
}
