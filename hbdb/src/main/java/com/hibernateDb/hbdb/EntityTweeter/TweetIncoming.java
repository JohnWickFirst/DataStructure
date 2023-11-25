package com.hibernateDb.hbdb.EntityTweeter;

public class TweetIncoming {

    private String shortName;

    private String tweet;

    private String category;

    public TweetIncoming(String shortName, String tweet, String category) {
        this.shortName = shortName;
        this.tweet = tweet;
        this.category = category;
    }

    public TweetIncoming() {
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
