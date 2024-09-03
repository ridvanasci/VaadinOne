package com.example.vaadinone;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "'USERS'")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int userID;

    private String name;



}
