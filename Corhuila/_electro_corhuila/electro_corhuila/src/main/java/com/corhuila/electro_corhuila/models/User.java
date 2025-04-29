package com.corhuila.electro_corhuila.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private String document;

    @Column(name = "socioeconomicStratum")
    private int socioeconomicStratum;

    // Constructor
    public User(String name, String document, int socioeconomicStratum) {
        this.name = name;
        this.document = document;
        this.socioeconomicStratum = socioeconomicStratum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @JsonProperty("socioeconomicStratum") // Anotación para manejar la conversión a camelCase
    public int getSocioeconomicStratum() {
        return socioeconomicStratum;
    }

    @JsonProperty("socioeconomicStratum") // Anotación para manejar la conversión a camelCase
    public void setSocioeconomicStratum(int socioeconomicStratum) {
        this.socioeconomicStratum = socioeconomicStratum;
    }

    public User() {
    }

}
