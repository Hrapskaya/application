package fintech.test.application.service;

import fintech.test.application.dto.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User save(User user);

    void update(User user);

    void changeStatus(User user);

    User findById(Integer id);

    Page<User> findPage(int page);
}
