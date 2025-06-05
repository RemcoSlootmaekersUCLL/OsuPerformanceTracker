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
            modRepository.save(new Mod(ModType.EZ, 0.50));
            modRepository.save(new Mod(ModType.NF, 0.50));
            modRepository.save(new Mod(ModType.HT, 0.30));
            modRepository.save(new Mod(ModType.HR, 1.06));
            modRepository.save(new Mod(ModType.SD, 1.06));
            modRepository.save(new Mod(ModType.PF, 1.06));
            modRepository.save(new Mod(ModType.DT, 1.12));
            modRepository.save(new Mod(ModType.NC, 1.12));
            modRepository.save(new Mod(ModType.HD, 1.06));
            modRepository.save(new Mod(ModType.FL, 1.06));
        }
    }
}
