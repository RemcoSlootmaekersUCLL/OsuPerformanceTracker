package com.examenpractice.osuperformancetracker.model;

import com.examenpractice.osuperformancetracker.model.enums.ModType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Mod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "mods")
    @JsonIgnore
    private List<Score> scores = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ModType modType;

    public Mod() {}

    public Mod(ModType modType) {
        this.modType = modType;
    }

    public int getId() {
        return id;
    }

    public ModType getModType() {
        return modType;
    }

    public double getScoreMultiplier() {
        return modType.getScoreMultiplier();
    }

    public void setModType(ModType modType) {
        this.modType = modType;
    }

    public List<Score> getScores() {
        return scores;
    }
}
