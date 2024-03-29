package com.gk.springhello.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import com.gk.springhello.security.AppRole;

/**
 * Custom user object for the application.
 *
 * @author Luke Taylor
 */
public class GaeUser implements Serializable {
    private final String userId;
    private final String email;
    private final String nickname;
    private final String forename;
    private final String surname;
    private final Set<AppRole> authorities;
    private final boolean enabled;
    private final ArrayList<String> followers;

    /**
     * Pre-registration constructor.
     *
     * Assigns the user the "NEW_USER" role only.
     */
    public GaeUser(String userId, String nickname, String email) {
        this.userId = userId;
        this.nickname = nickname;
        this.authorities = EnumSet.of(AppRole.USER);
        this.forename = null;
        this.surname = null;
        this.email = email;
        this.enabled = true;
        this.followers = null;
    }

    /**
     * Post-registration constructor
     */
    public GaeUser(String userId, String nickname, String email, String forename, String surname, Set<AppRole> authorities, boolean enabled) {
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
        this.authorities = authorities;
        this.forename = forename;
        this.surname = surname;
        this.enabled= enabled;
        this.followers = null;
    }

    public String getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Collection<AppRole> getAuthorities() {
        return authorities;
    }

    @Override
    public String toString() {
        return "GaeUser{" +
                "userId='" + userId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
