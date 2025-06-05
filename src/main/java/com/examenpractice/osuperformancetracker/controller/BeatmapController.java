package com.examenpractice.osuperformancetracker.controller;

import com.examenpractice.osuperformancetracker.model.Beatmap;
import com.examenpractice.osuperformancetracker.service.BeatmapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beatmaps")
public class BeatmapController {
    private final BeatmapService beatmapService;

    public BeatmapController(BeatmapService beatmapService) {
        this.beatmapService = beatmapService;
    }

    @GetMapping
    public List<Beatmap> getBeatmaps() {
        return beatmapService.getAllBeatmaps();
    }

    @GetMapping("/{id}")
    public Beatmap getBeatmapById(@PathVariable int id) {
        return beatmapService.getBeatmapById(id);
    }

    @GetMapping("/title/{title}")
    public List<Beatmap> getBeatmapByTitle(@PathVariable String title) {
        return beatmapService.getBeatmapByTitle(title);
    }

    @GetMapping("/artist/{artist}")
    public List<Beatmap> getBeatmapByArtist(@PathVariable String artist) {
        return beatmapService.getBeatmapByArtist(artist);
    }

    @GetMapping("/{title}/{artist}")
    public Beatmap getBeatmapByTitleAndArtist(@PathVariable String title, @PathVariable String artist) {
        return beatmapService.getBeatmapByTitleAndArtist(title, artist);
    }

    @PostMapping
    public Beatmap addBeatmap(@RequestBody Beatmap beatmap) {
        return beatmapService.addBeatmap(beatmap);
    }
}
