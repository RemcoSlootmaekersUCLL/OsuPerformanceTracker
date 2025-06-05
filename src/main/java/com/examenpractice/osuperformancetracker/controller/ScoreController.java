package com.examenpractice.osuperformancetracker.controller;

import com.examenpractice.osuperformancetracker.dto.ScoreRequest;
import com.examenpractice.osuperformancetracker.model.Mod;
import com.examenpractice.osuperformancetracker.model.Score;
import com.examenpractice.osuperformancetracker.repository.ModRepository;
import com.examenpractice.osuperformancetracker.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;
    private final ModRepository modRepository;

    public ScoreController(ScoreService scoreService, ModRepository modRepository) {
        this.scoreService = scoreService;
        this.modRepository = modRepository;
    }

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    @GetMapping("/player/{playerId}")
    public List<Score> getTopScoresByPlayer(@PathVariable long playerId) {
        return scoreService.getTopScoresByPlayer(playerId);
    }

    @GetMapping("/beatmap/{beatmapId}")
    public List<Score> getTopScoresByBeatmapId(@PathVariable long beatmapId) {
        return scoreService.getTopScoresByBeatmap(beatmapId);
    }

    @PostMapping
    public Score addScore(@RequestBody ScoreRequest request) {
        List<Mod> mods = modRepository.findAllById(request.modIds);
        return scoreService.addScore(request.playerId, request.beatmapId, request.accuracy, request.maxCombo, mods, request.timeStamp);
    }
}
