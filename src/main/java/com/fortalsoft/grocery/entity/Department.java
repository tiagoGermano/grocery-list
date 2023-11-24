package com.fortalsoft.grocery.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
}
