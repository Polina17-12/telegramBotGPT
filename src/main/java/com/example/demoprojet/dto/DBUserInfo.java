package com.example.demoprojet.dto;

import java.time.LocalDateTime;
import com.example.demoprojet.entity.InfoUsers;

public class DBUserInfo {
    private long id;
    private long usernameID;
    private String text;
    private LocalDateTime dateTime;

    public long getUsernameID() {
        return usernameID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUsernameID(Long usernameID) {
        this.usernameID = usernameID;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public InfoUsers toInfoUsers(){
        InfoUsers infoUsers = new InfoUsers();
        infoUsers.setDate(dateTime);
        infoUsers.setId(id);
        infoUsers.setTextUsers(text);
        infoUsers.setUserIdInTg(usernameID);
        return infoUsers;
    }
}
