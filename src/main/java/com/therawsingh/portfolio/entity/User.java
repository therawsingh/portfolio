package com.therawsingh.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.security.Provider;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;


}
