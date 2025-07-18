package com.rommiebubble.controllers;

import com.rommiebubble.entities.Casa;
import com.rommiebubble.repositories.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/casas")
public class CasaController {

    @Autowired
    private CasaRepository casaRepo;

    // Endpoint para crear una nueva casa
    @PostMapping("/crear")
    public Casa crearCasa(@RequestParam String nombre) {
        Casa nueva = new Casa(nombre); // Usa el constructor que genera el código automáticamente
        return casaRepo.save(nueva);
    }

    // Endpoint para listar todas las casas (opcional)
    @GetMapping("/listar")
    public java.util.List<Casa> listarCasas() {
        return casaRepo.findAll();
    }
}