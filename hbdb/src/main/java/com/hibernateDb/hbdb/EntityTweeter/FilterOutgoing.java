package com.hibernateDb.hbdb.EntityTweeter;

import java.time.LocalDateTime;

public class FilterOutgoing {

    private String msg;
    private LocalDateTime time;
    private String category;

    public FilterOutgoing(String msg, LocalDateTime time, String category) {
        this.msg = msg;
        this.time = time;
        this.category = category;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public FilterOutgoing() {
    }
}
