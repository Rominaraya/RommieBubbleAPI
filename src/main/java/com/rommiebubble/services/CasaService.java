package com.rommiebubble.services;

import com.rommiebubble.entities.Casa;
import com.rommiebubble.repositories.CasaRepository;
import org.springframework.stereotype.Service;

@Service
public class CasaService {

    private final CasaRepository casaRepo;

    public CasaService(CasaRepository casaRepo) {
        this.casaRepo = casaRepo;
    }

    public Casa buscarPorId(Integer id) {
        return casaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Casa no encontrada con ID: " + id));
    }
}