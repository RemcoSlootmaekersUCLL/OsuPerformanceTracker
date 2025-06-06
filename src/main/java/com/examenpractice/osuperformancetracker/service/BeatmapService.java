package com.examenpractice.osuperformancetracker.service;

import com.examenpractice.osuperformancetracker.exception.AlreadyExistsException;
import com.examenpractice.osuperformancetracker.exception.NotFoundException;
import com.examenpractice.osuperformancetracker.model.Beatmap;
import com.examenpractice.osuperformancetracker.repository.BeatmapRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class BeatmapService {
    private BeatmapRepository beatmapRepository;

    public BeatmapService(BeatmapRepository beatmapRepository) {
        this.beatmapRepository = beatmapRepository;
    }

    public List<Beatmap> getAllBeatmaps() {
        List<Beatmap> allBeatmaps = beatmapRepository.findAll();
        if (allBeatmaps.isEmpty()) {
            throw new NotFoundException("No beatmaps found");
        }
        return allBeatmaps;
    }

    public Beatmap addBeatmap(Beatmap beatmap) {
        if (beatmapRepository.existsById(beatmap.getId())) {
            throw new AlreadyExistsException("Beatmap already exists");
        }
        return beatmapRepository.save(beatmap);
    }

    public Beatmap getBeatmapById(long id) {
        return beatmapRepository.findBeatmapById(id);
    }

    public List<Beatmap> getBeatmapByTitle(String title) {
        List<Beatmap> foundBeatmaps = beatmapRepository.findBeatmapByTitleContainsIgnoreCase(title.toLowerCase());
        if (foundBeatmaps.isEmpty()) {
            throw new NotFoundException("No beatmap found with title " + title);
        }
        return foundBeatmaps;
    }

    public List<Beatmap> getBeatmapByArtist(String artist) {
        List<Beatmap> foundBeatmaps = beatmapRepository.findBeatmapByArtistContainsIgnoreCase(artist);
        if (foundBeatmaps.isEmpty()) {
            throw new NotFoundException("No beatmap found with artist " + artist);
        }
        return foundBeatmaps;
    }

    public Beatmap getBeatmapByTitleAndArtist(String title, String artist) {
        Beatmap foundBeatmap = beatmapRepository.findBeatmapByTitleAndArtistContainsIgnoreCase(title, artist);
        if (foundBeatmap == null) {
            throw new NotFoundException("No beatmap found with title and artist: " + title + " - " + artist);
        }
        return foundBeatmap;
    }
}
