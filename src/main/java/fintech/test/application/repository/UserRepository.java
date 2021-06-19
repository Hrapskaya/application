package fintech.test.application.repository;

import fintech.test.application.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Integer> {

    UserAccount findByUserName(String userName);
}
