package com.rommiebubble.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rommiebubble.entities.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
    Usuario findByEmail(String email);
    List<Usuario> findByCasaId(Integer casaId);

}
