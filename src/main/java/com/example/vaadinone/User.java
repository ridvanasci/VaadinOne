package com.example.vaadinone;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Table(name = "'USERS'")
@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userID;
    private  String name;
    private Instant zaman= Instant.now();

    public User(int id, String name) {

 userID =id;
 this.name =name;
 }
}









