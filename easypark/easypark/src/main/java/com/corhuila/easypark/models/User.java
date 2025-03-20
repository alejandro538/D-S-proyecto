package com.corhuila.easypark.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity

public class User {

@Id 
@GeneratedValue(strategy = GenerationType.AUTO)
@Column (nullable = false)
private Integer id;

@Column (nullable = false)
private String fullName;

@Column (unique = true, length = 100, nullable = false )
private String email;

@Column(nullable = false) 
private String password;

}
