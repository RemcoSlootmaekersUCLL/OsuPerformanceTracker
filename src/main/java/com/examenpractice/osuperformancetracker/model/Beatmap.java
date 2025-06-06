package com.examenpractice.osuperformancetracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Beatmap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title is required.")
    private String title;

    @NotBlank(message = "Artist is required.")
    private String artist;

    @NotBlank(message = "Difficulty is required.")
    private String difficulty;

    @NotNull(message = "BPM is required.")
    @Positive(message = "BPM must be a positive number.")
    private int bpm;

    @NotBlank(message = "Creator is required.")
    private String creator;

    @OneToMany(mappedBy = "beatmap")
    @JsonIgnore
    private List<Score> scoreList = new ArrayList<>();

    public Beatmap() {}

    public Beatmap(String title, String artist, String difficulty, int bpm, String creator) {
        setTitle(title);
        setArtist(artist);
        setDifficulty(difficulty);
        setBpm(bpm);
        setCreator(creator);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
