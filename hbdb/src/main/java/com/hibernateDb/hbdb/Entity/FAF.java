package com.hibernateDb.hbdb.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name="FAF")
public class FAF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Trying with ArrayList first, if required will create a data structure class to be more specific
    @Column(name="Followee")
    private ArrayList<String> followee;

    @Column(name="Followers")
    private ArrayList<String> follower;

    public FAF(ArrayList<String> followee, ArrayList<String> follower) {
        this.followee = followee;
        this.follower = follower;
    }
    public FAF(){

    }

    public ArrayList<String> getFollowee() {
        return followee;
    }

    public void setFollowee(ArrayList<String> followee) {
        this.followee = followee;
    }

    public ArrayList<String> getFollower() {
        return follower;
    }

    public void setFollower(ArrayList<String> follower) {
        this.follower = follower;
    }
}
