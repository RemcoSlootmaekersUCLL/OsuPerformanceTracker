package com.examenpractice.osuperformancetracker.repository;

import com.examenpractice.osuperformancetracker.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    public boolean existsById(long id);
    public boolean existsByUsername(String username);
    public Player findPlayerById(long id);
    public Player findPlayerByUsername(String username);
    public void deletePlayerById(long id);
}
