package com.rommiebubble.services;

import com.rommiebubble.entities.Casa;
import com.rommiebubble.entities.Usuario;
import com.rommiebubble.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;

    public UsuarioService(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public Usuario crearUsuario(String nombre, String email, Casa casa) {
        if (usuarioRepo.existsByEmail(email)) {
            throw new RuntimeException("Ya existe un usuario con ese email");
        }

        Usuario nuevo = new Usuario(nombre, email, casa);
        return usuarioRepo.save(nuevo);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepo.findByEmail(email);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepo.findAll();
    }

    public List<Usuario> listarPorCasa(Integer casaId) {
        return usuarioRepo.findByCasaId(casaId);
    }


}
