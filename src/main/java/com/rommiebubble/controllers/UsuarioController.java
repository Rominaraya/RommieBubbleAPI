package com.rommiebubble.controllers;

import com.rommiebubble.entities.Usuario;
import com.rommiebubble.entities.Casa;
import com.rommiebubble.services.CasaService;
import com.rommiebubble.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CasaService casaService;

    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestParam String nombre,
                                @RequestParam String email,
                                @RequestParam Integer casaId) {

        Casa casa = casaService.buscarPorId(casaId);

        return usuarioService.crearUsuario(nombre, email, casa);
    }

    @GetMapping("/buscar")
    public Usuario buscarPorEmail(@RequestParam String email) {
        return usuarioService.buscarPorEmail(email);
    }

    @GetMapping("/listarPorCasa")
    public List<Usuario> listarUsuariosPorCasa(@RequestParam Integer casaId) {
        return usuarioService.listarPorCasa(casaId);
    }

}