package com.example.SignupApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;

    private String roleName;
    private boolean isActive;

    @OneToMany(mappedBy="role",cascade = CascadeType.ALL)
    @JsonBackReference
    @JsonIgnore
    private List<NewUser> users;

    public Role(int roleId, String roleName, boolean isActive, List<NewUser> users) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.isActive = isActive;
        this.users = users;
    }

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<NewUser> getUsers() {
        return users;
    }

    public void setUsers(List<NewUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", isActive=" + isActive +
                ", users=" + users +
                '}';
    }
}

