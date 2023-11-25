package com.hibernateDb.hbdb.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Profile")
@NamedQueries({

        @NamedQuery(
                name="findByShortName",
                query="select user from Profile user LEFT JOIN FETCH user.tweets where user.shortName = :shortName"

        ),
        @NamedQuery(
                name="searchProfile",
                query="select user.shortName from Profile user"

        )
})
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Size(min=1, max=100)
    @Column(name="name")
    private String name;

    @NotNull
    @NotBlank
    @Size(min=1, max=100)
    @Column(name="shortName")
    private String shortName;

    @NotNull
    @NotBlank
    @Size(min=1, max=100)
    @Column(name="password")
    private String password;


    //for now it will be true or false later will set the validation manually
    // Vlaidation needs to be set manually
    @Column(name="validated")
    private Boolean validate;

    @NotNull
    @NotBlank
    @Size(min=10, max=10)
    @Column(name="phoneNumber")
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Email(message = "Invalid Email Pattern")
    @Column(name="emailId")
    private String gmailId;

    @Column(name="common")
    private ArrayList<String> common;

    @Column(name="star")
    private ArrayList<String> star;

    @OneToMany(mappedBy = "userProfile", fetch = FetchType.EAGER)
    private List<Tweet> tweets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getValidate() {
        return validate;
    }

    public void setValidate(Boolean validate) {
        this.validate = validate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGmailId() {
        return gmailId;
    }

    public void setGmailId(String gmailId) {
        this.gmailId = gmailId;
    }

    public ArrayList<String> getCommon() {
        return common;
    }

    public void setCommon(String follow) {
        if(common==null){
            common= new ArrayList<String>();
        }
        common.add(follow);
    }

    public ArrayList<String> getStar() {
        return star;
    }

    public void setStar(String follow) {
        if(star==null){
            star=new ArrayList<String>();
        }
        star.add(follow);
    }

    public List<Tweet> getTweet() {
        return tweets;
    }

    public void setTweet(List<Tweet> tweet) {
        this.tweets = tweet;
    }

    public Profile(String name, String shortName, String password, Boolean validate, String phoneNumber, String gmailId) {
        this.name = name;
        this.shortName = shortName;
        this.password = password;
        this.validate = validate;
        this.phoneNumber = phoneNumber;
        this.gmailId = gmailId;
    }

    public Profile(String name, String shortName, String password, Boolean validate, String phoneNumber, String gmailId, ArrayList<String> common, ArrayList<String> star, List<Tweet> tweets) {
        this.name = name;
        this.shortName = shortName;
        this.password = password;
        this.validate = validate;
        this.phoneNumber = phoneNumber;
        this.gmailId = gmailId;
        this.common = common;
        this.star = star;
        this.tweets = tweets;
    }

    public void addTweet(Tweet tweet){
        if(tweets==null){
            tweets=new ArrayList<Tweet>();
        }
        tweets.add(tweet);
        try {
            tweet.setUserProfile(this);
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public Profile(){

    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", password='" + password + '\'' +
                ", validate=" + validate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gmailId='" + gmailId + '\'' +
                ", common=" + common +
                ", star=" + star +
                ", tweets=" + tweets +
                '}';
    }
}
