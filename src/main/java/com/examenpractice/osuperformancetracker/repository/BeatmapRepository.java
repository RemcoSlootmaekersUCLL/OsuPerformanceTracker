package com.examenpractice.osuperformancetracker.repository;

import com.examenpractice.osuperformancetracker.model.Beatmap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeatmapRepository extends JpaRepository<Beatmap, Integer> {
    public boolean existsById(long id);
    public Beatmap findBeatmapById(long id);
    public List<Beatmap> findBeatmapByTitleContainsIgnoreCase(String title);
    public List<Beatmap> findBeatmapByArtistContainsIgnoreCase(String artist);
    public Beatmap findBeatmapByTitleAndArtistContainsIgnoreCase(String title, String artist);
}
