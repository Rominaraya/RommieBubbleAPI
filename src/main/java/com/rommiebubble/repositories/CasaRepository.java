package com.rommiebubble.repositories;

import com.rommiebubble.entities.Casa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasaRepository extends JpaRepository<Casa, Integer> {
}