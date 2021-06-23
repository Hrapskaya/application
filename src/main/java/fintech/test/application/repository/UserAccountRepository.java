package fintech.test.application.repository;

import fintech.test.application.domain.entity.UserAccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Integer>, JpaSpecificationExecutor<UserAccountEntity> {

    UserAccountEntity findByUsername(String username);

    Page<UserAccountEntity> findAll(Pageable pageable);

    @Override
    Page<UserAccountEntity> findAll(Specification<UserAccountEntity> spec, Pageable pageable);
}
