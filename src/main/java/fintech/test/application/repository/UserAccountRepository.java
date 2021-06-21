package fintech.test.application.repository;

import fintech.test.application.entity.UserAccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Integer> {

    UserAccountEntity findByUserName(String userName);

    Page<UserAccountEntity> findAll(Pageable pageable);

}
