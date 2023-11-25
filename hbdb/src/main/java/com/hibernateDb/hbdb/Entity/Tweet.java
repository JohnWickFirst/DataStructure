package com.hibernateDb.hbdb.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name="tweet")
@NamedQueries({

        @NamedQuery(
                name="getTweet",
                query="select t from Tweet t"

        )


})
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Size(min=1,max=140)
    private String tweet;

    private LocalDateTime dateTime;

    @NotNull
    @NotBlank
    private String category;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile userProfile;

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Tweet(String tweet, String category) {
        this(tweet,LocalDateTime.now(),category);
    }

    public Tweet(String tweet, LocalDateTime dateTime, String category) {
        this.tweet = tweet;
        this.dateTime = dateTime;
        this.category = category;
    }

    public Tweet() {
    }

    public Profile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
    }
}
