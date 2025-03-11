package com.example.demoprojet.dto;

import java.time.LocalDateTime;

public class DBUserInfo {
    private int id;
    private String usernameID;
    private String text;
    private LocalDateTime dateTime;

    public String getUsernameID() {
        return usernameID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
