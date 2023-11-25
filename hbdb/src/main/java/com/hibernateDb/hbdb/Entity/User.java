package com.hibernateDb.hbdb.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")

@NamedQueries({

        @NamedQuery(
                name="findUserById",
                query="select user from User user where user.userId = :userId"

        ),
        @NamedQuery(
                name="deleteUserById",
                query="DELETE from User user where user.userId = :userId"
        )


})
public class User {

    @Id
    @GeneratedValue(generator = "idGeneratorImpl")
    private int bankUserId;

    @Column(name="userId")
    private String userId;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private boolean enabled;

    public User(String userId, String password, boolean enabled) {
        this.userId = userId;
        this.password = password;
        this.enabled = enabled;
    }

    public User() {
    }

    public User(String userId, boolean enabled) {
        this.userId = userId;
        this.enabled = enabled;
    }

    public int getBankUserId() {
        return bankUserId;
    }

    public void setBankUserId(int bankUserId) {
        this.bankUserId = bankUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
