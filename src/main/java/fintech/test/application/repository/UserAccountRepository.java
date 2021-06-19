package fintech.test.application.repository;

import fintech.test.application.entity.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    UserAccount findByUserName(String userName);

    Page<UserAccount> findAll(Pageable pageable);
}
