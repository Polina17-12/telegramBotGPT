package com.example.demoprojet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

import java.io.Serializable;
@Entity
@Table(name = "users")
public class infoUsers  implements Serializable{


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "id_in_tg", unique = true, nullable = false)
        private Long userName;

        @Column(name = "text_users", nullable = false)
        private String textUsers;

        @Column(name = "date")
        private LocalDateTime date;


}
