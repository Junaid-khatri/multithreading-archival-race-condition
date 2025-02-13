package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    int age;
    boolean isStudent;
    String workPlace;
    boolean isUpdated;
    boolean isDeleted;
    boolean isArchived;
    
}
