package com.example.demoprojet.entity;

import com.example.demoprojet.dto.DBUserInfo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

import java.io.Serializable;
@Entity
@Table(name = "users")
public class InfoUsers implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "id_in_tg", unique = true)
        private Long userIdInTg;

        @Column(name = "text_users", nullable = false)
        private String textUsers;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getUserIdInTg() {
                return userIdInTg;
        }

        public void setUserIdInTg(Long userIdInTg) {
                this.userIdInTg = userIdInTg;
        }

        public String getTextUsers() {
                return textUsers;
        }

        public void setTextUsers(String textUsers) {
                this.textUsers = textUsers;
        }

        public LocalDateTime getDate() {
                return date;
        }

        public void setDate(LocalDateTime date) {
                this.date = date;
        }

        @Column(name = "date")
        private LocalDateTime date;

        public DBUserInfo ToDBUserInfo(){
                DBUserInfo dbUserInfo = new DBUserInfo();
                dbUserInfo.setDateTime(date);
                dbUserInfo.setId(id);
                dbUserInfo.setText(textUsers);
                dbUserInfo.setUsernameID(userIdInTg);
                return dbUserInfo;
        }
}
