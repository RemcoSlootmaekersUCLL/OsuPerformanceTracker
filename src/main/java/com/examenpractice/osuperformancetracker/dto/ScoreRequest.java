package com.examenpractice.osuperformancetracker.dto;

import java.util.List;

public class ScoreRequest {
    public long playerId;
    public long beatmapId;
    public double accuracy;
    public int maxCombo;
    public List<Integer> modIds;
    public String timeStamp;
    public int score;
}
