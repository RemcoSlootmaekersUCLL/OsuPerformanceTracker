package com.examenpractice.osuperformancetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Player is required.")
    @ManyToOne
    private Player player;

    @NotNull(message = "Beatmap is required.")
    @ManyToOne
    private Beatmap beatmap;

    @NotNull(message = "Accuracy is required.")
    private double accuracy;

    @NotNull(message = "Max combo is required.")
    private int maxCombo;

    @NotNull(message = "Score is required.")
    private int score;

    @NotNull(message = "Mod list is required. If there are no mods, simply pass an empty list.")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "score_mods",
            joinColumns = @JoinColumn(name = "score_id"),
            inverseJoinColumns = @JoinColumn(name = "mod_id")
    )
    private List<Mod> mods = new ArrayList<>();

    @NotBlank(message = "Timestamp is required.")
    private String timeStamp;

    private double totalMultiplier;

    public Score() {}

    public Score(Player player, Beatmap beatmap, double accuracy, int maxCombo, List<Mod> mods, String timeStamp) {
        setPlayer(player);
        setBeatmap(beatmap);
        setAccuracy(accuracy);
        setMaxCombo(maxCombo);
        setMods(mods);
        setTimeStamp(timeStamp);
    }

    public long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Beatmap getBeatmap() {
        return beatmap;
    }

    public void setBeatmap(Beatmap beatmap) {
        this.beatmap = beatmap;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getMaxCombo() {
        return maxCombo;
    }

    public void setMaxCombo(int maxCombo) {
        this.maxCombo = maxCombo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Mod> getMods() {
        return mods;
    }

    public void setMods(List<Mod> mods) {
        this.mods = mods;

        double multiplier = 1.0;
        for (Mod mod : mods) {
            multiplier *= mod.getScoreMultiplier();
        }

        this.totalMultiplier = multiplier;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
