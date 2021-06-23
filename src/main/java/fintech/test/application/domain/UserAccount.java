package fintech.test.application.domain;

import fintech.test.application.constant.Regexp;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import static fintech.test.application.constant.Message.*;

public class UserAccount implements UserDetails {

    private Integer id;

    @NotBlank(message = USER_NAME_BLANCK)
    @Length(min = 3, max = 16, message = USER_NAME_WRONG_LENGTH)
    @Pattern(regexp = Regexp.USER_NAME, message = USER_NAME_MISMATCH_REGEXP)
    private String username;

    @Length(min = 3, max = 16, message = PASSWORD_WRONG_LENGTH)
    @Pattern(regexp = Regexp.PASSWORD, message = PASSWORD_MISMATCH_REGEXP)
    private String password;

    @NotBlank(message = FIRST_NAME_BLANCK)
    @Length(min = 3, max = 16, message = FIRST_NAME_WRONG_LENGTH)
    @Pattern(regexp = Regexp.FIRST_NAME, message = FIRST_NAME_MISMATCH_REGEXP)
    private String firstName;

    @NotBlank(message = LAST_NAME_BLANCK)
    @Length(min = 3, max = 16, message = LAST_NAME_WRONG_LENGTH)
    @Pattern(regexp = Regexp.LAST_NAME, message = LAST_NAME_MISMATCH_REGEXP)
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
}
