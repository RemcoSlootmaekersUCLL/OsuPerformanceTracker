package com.examenpractice.osuperformancetracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username is required.")
    private String username;

    @NotNull(message = "Join date is required.")
    private LocalDate joinDate;

    @NotBlank(message = "Country is required.")
    private String country;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Score> scores = new ArrayList<>();

    public Player() {}

    public Player(String username, LocalDate joinDate, String country) {
        setUsername(username);
        setJoinDate(joinDate);
        setCountry(country);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public String getCountry() {
        return country;
    }
}
