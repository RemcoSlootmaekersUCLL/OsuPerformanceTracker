package com.examenpractice.osuperformancetracker.service;

import com.examenpractice.osuperformancetracker.model.Mod;
import com.examenpractice.osuperformancetracker.model.Player;
import com.examenpractice.osuperformancetracker.model.Beatmap;

import com.examenpractice.osuperformancetracker.model.enums.ModType;
import com.examenpractice.osuperformancetracker.repository.BeatmapRepository;
import com.examenpractice.osuperformancetracker.repository.ModRepository;
import com.examenpractice.osuperformancetracker.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(2)
public class DataInitializer implements CommandLineRunner {
    private final PlayerRepository playerRepository;
    private final BeatmapRepository beatmapRepository;
    private final ModRepository modRepository;
    private final ScoreService scoreService;

    public DataInitializer(PlayerRepository playerRepository, BeatmapRepository beatmapRepository, ScoreService scoreService, ModRepository modRepository) {
        this.playerRepository = playerRepository;
        this.beatmapRepository = beatmapRepository;
        this.scoreService = scoreService;
        this.modRepository = modRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Player kurookami = new Player("Kurookami", LocalDate.parse("2020-10-03"), "BE");
        playerRepository.save(kurookami);
        Beatmap minamo = new Beatmap("Minamo no Sakura, Yume wa Sakayume", "otetsu", "Reversed Dream", 200, "Riven");
        beatmapRepository.save(minamo);

        List<Mod> mods = new ArrayList<>();
        modRepository.findByModType(ModType.HD).ifPresent(mods::add);

        scoreService.addScore(1L, 1L, 98.94, 816, mods, "2025-01-21 22:00");

        System.out.println("Database initialized~~");
    }
}
