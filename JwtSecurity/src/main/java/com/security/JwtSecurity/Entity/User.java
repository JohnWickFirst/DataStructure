package com.security.JwtSecurity.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Auth_Table")
@NamedQueries(
        @NamedQuery(
                name="findUser",
                query="select user from User user where user.userName = :userName"
        )
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }
}
