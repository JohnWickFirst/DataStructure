package com.security.JwtSecurity.AuthUtils;

import java.util.List;

public class UserAuth {

    private String userName;
    private String password;

    private List<String> roles;

    public UserAuth() {
    }

    public UserAuth(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserAuth(String userName, String password, List<String> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
