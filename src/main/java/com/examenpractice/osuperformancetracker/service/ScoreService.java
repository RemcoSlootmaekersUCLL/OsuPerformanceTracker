package com.examenpractice.osuperformancetracker.service;

import com.examenpractice.osuperformancetracker.exception.NotFoundException;
import com.examenpractice.osuperformancetracker.model.Beatmap;
import com.examenpractice.osuperformancetracker.model.Mod;
import com.examenpractice.osuperformancetracker.model.Player;
import com.examenpractice.osuperformancetracker.repository.BeatmapRepository;
import com.examenpractice.osuperformancetracker.repository.PlayerRepository;
import com.examenpractice.osuperformancetracker.repository.ScoreRepository;
import org.springframework.stereotype.Service;
import com.examenpractice.osuperformancetracker.model.Score;
import java.util.List;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final PlayerRepository playerRepository;
    private final BeatmapRepository beatmapRepository;

    public ScoreService(ScoreRepository scoreRepository, PlayerRepository playerRepository, BeatmapRepository beatmapRepository) {
        this.scoreRepository = scoreRepository;
        this.playerRepository = playerRepository;
        this.beatmapRepository = beatmapRepository;
    }

    public List<Score> getAllScores() {
        List<Score> allScores = scoreRepository.findAll();
        if (allScores.isEmpty()) {
            throw new NotFoundException("No scores found");
        }
        return allScores;
    }

    public Score addScore(long playerId, long beatmapId, double accuracy, int maxCombo, List<Mod> mods, String timeStamp) {
        if (!playerRepository.existsById(playerId)) {
            throw new NotFoundException("Player not found.");
        }
        if (!beatmapRepository.existsById(beatmapId)) {
            throw new NotFoundException("Beatmap not found.");
        }

        Player player = playerRepository.findPlayerById(playerId);
        Beatmap beatmap = beatmapRepository.findBeatmapById(beatmapId);

        Score score = new Score();
        score.setPlayer(player);
        score.setBeatmap(beatmap);
        score.setAccuracy(accuracy);
        score.setMaxCombo(maxCombo);
        score.setMods(mods);
        score.setTimeStamp(timeStamp);

        return scoreRepository.save(score);
    }

    public List<Score> getTopScoresByPlayer(long playerId) {
        List<Score> topScores = scoreRepository.findTop10ScoresByPlayerIdOrderByScoreDesc(playerId);
        if (topScores.isEmpty()) {
            throw new NotFoundException("No scores found");
        }
        return topScores;
    }

    public List<Score> getTopScoresByBeatmap(long beatmapId) {
        List<Score> topScores = scoreRepository.findTop10ScoresByBeatmapIdOrderByScoreDesc(beatmapId);
        if (topScores.isEmpty()) {
            throw new NotFoundException("No scores found");
        }
        return topScores;
    }
}
