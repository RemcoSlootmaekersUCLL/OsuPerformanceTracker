package com.examenpractice.osuperformancetracker.controller;

import com.examenpractice.osuperformancetracker.model.Player;
import com.examenpractice.osuperformancetracker.service.PlayerService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/id/{id}")
    public Player getPlayer(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    @GetMapping("/username/{username}")
    public Player getPlayerByUsername(@PathVariable String username) {
        return playerService.getPlayer(username);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.registerPlayer(player);
    }

    @Transactional
    @DeleteMapping("/id/{id}")
    public String deletePlayer(@PathVariable long id) {
        return playerService.deletePlayer(id);
    }
}
