package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoEntityArchival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    int age;
    boolean isStudent;
    String workPlace;
    boolean isUpdated;
    boolean isDeleted;
}
