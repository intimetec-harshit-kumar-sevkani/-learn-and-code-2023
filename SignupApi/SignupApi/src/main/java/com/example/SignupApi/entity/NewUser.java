package com.example.SignupApi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
public class NewUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int userId;
    private String userName;

    private String email;

    private String name ;

    private String password ;

    @ManyToOne
    @JoinColumn(name="roleId", nullable=false)
    @JsonManagedReference
    private Role role;


    private boolean isActive;

    public NewUser(int userId, String userName, String name, String password, Role role, boolean isActive, String email) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
        this.isActive = isActive;
    }



    public NewUser() {
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", isActive=" + isActive +
                '}';
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
}

