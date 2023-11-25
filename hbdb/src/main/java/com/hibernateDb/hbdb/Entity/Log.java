package com.hibernateDb.hbdb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="Msg")
    private String msg;

    @Column(name="Time_Taken")
    private String timeTaken;

    @Column(name="Https_Codes")
    private String httpsCodes;

    public Log(String msg, String timeTaken, String httpsCodes) {
        this.msg = msg;
        this.timeTaken = timeTaken;
        this.httpsCodes = httpsCodes;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getHttpsCodes() {
        return httpsCodes;
    }

    public void setHttpsCodes(String httpsCodes) {
        this.httpsCodes = httpsCodes;
    }

    public Log() {
    }
}
