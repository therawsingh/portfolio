package com.therawsingh.portfolio.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;


}
