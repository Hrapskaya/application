package fintech.test.application.domain;

import fintech.test.application.constant.RegexpConstant;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import static fintech.test.application.constant.MessageConstant.*;
import static fintech.test.application.constant.RegexpConstant.*;

public class UserAccount implements UserDetails {

    private Integer id;

    @NotBlank(message = USER_NAME_BLANCK)
    @Length(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE, message = USER_NAME_WRONG_LENGTH)
    @Pattern(regexp = USER_NAME_REGEX, message = USER_NAME_MISMATCH_REGEXP)
    private String username;

    @Pattern(regexp = PASSWORD_REGEX, message = PASSWORD_MISMATCH_REGEXP)
    private String password;

    @NotBlank(message = FIRST_NAME_BLANCK)
    @Length(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE, message = FIRST_NAME_WRONG_LENGTH)
    @Pattern(regexp = FIRST_NAME_REGEX, message = FIRST_NAME_MISMATCH_REGEXP)
    private String firstName;

    @NotBlank(message = LAST_NAME_BLANCK)
    @Length(min = MIN_NAME_SIZE, max = MAX_NAME_SIZE, message = LAST_NAME_WRONG_LENGTH)
    @Pattern(regexp = RegexpConstant.LAST_NAME_REGEX, message = LAST_NAME_MISMATCH_REGEXP)
    private String lastName;

    private UserRole role;

    private UserStatus status;

    private LocalDate createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status == UserStatus.ACTIVE;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority(ROLE_PREFIX + role));
        return Collections.singleton(role);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }
}
