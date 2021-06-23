package fintech.test.application.service;

import fintech.test.application.domain.entity.UserAccountEntity;
import fintech.test.application.domain.UserRole;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserAccountSpecification implements Specification<UserAccountEntity>{

    private String filterUsername;
    private String filterUserRole;
    private Pageable pageable;

    public UserAccountSpecification(String filterUsername, String filterUserRole, Pageable pageable) {
        this.filterUsername = filterUsername;
        this.filterUserRole = filterUserRole;
        this.pageable = pageable;
    }

    @Override
    public Predicate toPredicate(Root<UserAccountEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();
        if (!filterUsername.isEmpty()) {
            predicate = criteriaBuilder
                    .and(predicate, criteriaBuilder.like(root.get("username"), "%" + filterUsername + "%"));
        }
        if (!filterUserRole.isEmpty()) {
            predicate = criteriaBuilder
                    .and(predicate, criteriaBuilder.equal(root.get("role"), UserRole.valueOf(filterUserRole)));
        }
        query.orderBy(criteriaBuilder.desc(root.get("id")));
        return predicate;
    }
}
