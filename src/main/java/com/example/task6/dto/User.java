package com.example.task6.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user", indexes = @Index(name = "idx_name", columnList = "name"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Constructors, getters, and setters
}

