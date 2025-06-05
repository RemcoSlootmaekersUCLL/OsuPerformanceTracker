package com.examenpractice.osuperformancetracker.model.enums;

public enum ModType {
    EZ(0.50),
    NF(0.50),
    HT(0.30),
    HR(1.06),
    SD(1.00),
    PF(1.00),
    DT(1.12),
    NC(1.12),
    HD(1.06),
    FL(1.12);

    private final double scoreMultiplier;

    ModType(double scoreMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
    }

    public double getScoreMultiplier() {
        return scoreMultiplier;
    }
}
