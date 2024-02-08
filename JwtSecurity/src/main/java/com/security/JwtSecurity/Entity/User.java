package com.security.JwtSecurity.Entity;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name="Auth_Table")
@NamedQueries({
        @NamedQuery(
                name = "findUserById",
                query = "select user from User user where user.userName = :userName"
        ),
        @NamedQuery(
                name = "getAllUser",
                query = "select u from User u"
        )

})

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



    @Column(name="date")
    private LocalDate date;

    public User() {

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


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User(String userName, String password, boolean enabled, LocalDate date) {
        this.userName = userName;
        this.password = password;
        this.date = date;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {

    }
}
