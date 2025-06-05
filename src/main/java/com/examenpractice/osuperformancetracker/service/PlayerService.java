package com.examenpractice.osuperformancetracker.service;

import com.examenpractice.osuperformancetracker.exception.AlreadyExistsException;
import com.examenpractice.osuperformancetracker.exception.NotFoundException;
import com.examenpractice.osuperformancetracker.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import com.examenpractice.osuperformancetracker.model.Player;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        List<Player> allPlayers = playerRepository.findAll();
        if (allPlayers.isEmpty()) {
            throw new NotFoundException("No players found");
        }
        return allPlayers;
    }

    public Player registerPlayer(Player player) {
        if (playerRepository.existsById(player.getId())) {
            throw new AlreadyExistsException("Player already exists");
        }
        return playerRepository.save(player);
    }

    public Player getPlayer(long playerId) {
        if (!playerRepository.existsById(playerId)) {
            throw new NotFoundException("Player not found");
        }
        return playerRepository.findPlayerById(playerId);
    }

    public Player getPlayer(String username) {
        if (!playerRepository.existsByUsername(username)) {
            throw new NotFoundException("Player not found");
        }
        return playerRepository.findPlayerByUsername(username);
    }

    public String deletePlayer(long playerId) {
        if (!playerRepository.existsById(playerId)) {
            throw new NotFoundException("Player not found");
        }
        playerRepository.deletePlayerById(playerId);
        return "Player successfully deleted.";
    }

}
