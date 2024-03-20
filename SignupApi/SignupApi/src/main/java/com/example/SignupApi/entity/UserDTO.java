package com.example.SignupApi.entity;

public class UserDTO {

    private String name;
    private String password;

    private String email;
    private String roleName;
    private String userName;

    public UserDTO() {
    }

    public UserDTO(String name, String password, String roleName, String userName, String email) {
        this.name = name;
        this.password = password;
        this.roleName = roleName;
        this.userName = userName;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roleName='" + roleName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
