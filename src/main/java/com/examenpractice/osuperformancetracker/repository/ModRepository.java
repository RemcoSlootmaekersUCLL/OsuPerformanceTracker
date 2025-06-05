package com.examenpractice.osuperformancetracker.repository;

import com.examenpractice.osuperformancetracker.model.Mod;
import com.examenpractice.osuperformancetracker.model.enums.ModType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModRepository extends JpaRepository<Mod, Integer> {
    Optional<Mod> findByModType(ModType modType);
}
