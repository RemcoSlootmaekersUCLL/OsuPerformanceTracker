package com.examenpractice.osuperformancetracker.repository;

import com.examenpractice.osuperformancetracker.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    public boolean existsById(long id);
    public List<Score> findTop10ScoresByPlayerIdOrderByScoreDesc(long playerId);
    public List<Score> findTop10ScoresByBeatmapIdOrderByScoreDesc(long beatmapId);
}
