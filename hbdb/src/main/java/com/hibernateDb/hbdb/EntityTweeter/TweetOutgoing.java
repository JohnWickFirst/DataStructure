package com.hibernateDb.hbdb.EntityTweeter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class TweetOutgoing {


    private List<FilterOutgoing> msg;
    private String shortName;

    public TweetOutgoing(List<FilterOutgoing> msg, String shortName) {
        this.msg = msg;
        this.shortName = shortName;
    }

    public TweetOutgoing() {
    }

    public List<FilterOutgoing> getMsg() {
        return msg;
    }

    public void setMsg(List<FilterOutgoing> msg) {
        this.msg = msg;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
