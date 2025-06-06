package com.examenpractice.osuperformancetracker.service;

import com.examenpractice.osuperformancetracker.model.Mod;
import com.examenpractice.osuperformancetracker.model.enums.ModType;
import com.examenpractice.osuperformancetracker.repository.ModRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ModInitializer implements CommandLineRunner {

    private final ModRepository modRepository;

    public ModInitializer(ModRepository modRepository) {
        this.modRepository = modRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (modRepository.count() == 0) {
            modRepository.save(new Mod(ModType.EZ));
            modRepository.save(new Mod(ModType.NF));
            modRepository.save(new Mod(ModType.HT));
            modRepository.save(new Mod(ModType.HR));
            modRepository.save(new Mod(ModType.SD));
            modRepository.save(new Mod(ModType.PF));
            modRepository.save(new Mod(ModType.DT));
            modRepository.save(new Mod(ModType.NC));
            modRepository.save(new Mod(ModType.HD));
            modRepository.save(new Mod(ModType.FL));
        }
    }
}
