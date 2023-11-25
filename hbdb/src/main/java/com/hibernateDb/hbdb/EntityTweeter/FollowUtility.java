package com.hibernateDb.hbdb.EntityTweeter;

public class FollowUtility {

    private String userShortName;
    private String followeeShortName;

    public FollowUtility(String userShortName, String followeeShortName) {
        this.userShortName = userShortName;
        this.followeeShortName = followeeShortName;
    }

    public String getUserShortName() {
        return userShortName;
    }

    public void setUserShortName(String userShortName) {
        this.userShortName = userShortName;
    }

    public String getFolloweeShortName() {
        return followeeShortName;
    }

    public void setFolloweeShortName(String followeeShortName) {
        this.followeeShortName = followeeShortName;
    }
}
