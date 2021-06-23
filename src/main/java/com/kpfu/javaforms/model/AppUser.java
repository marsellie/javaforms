package com.kpfu.javaforms.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class AppUser extends GenericEntity<Long> implements UserDetails {

    private String username;
    private String nickname;
    private String password;

    @ElementCollection(targetClass = Roles.class)
    @Enumerated(value = EnumType.STRING)
    private Set<Roles> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public enum Roles implements GrantedAuthority {
        ADMIN, USER;

        @Override
        public String getAuthority() {
            return toString();
        }
    }
}
