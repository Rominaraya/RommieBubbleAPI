package com.rommiebubble.controllers;

import com.rommiebubble.entities.Casa;
import com.rommiebubble.repositories.CasaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CasaController.class)
class CasaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class CasaConfig {
        @Bean
        public CasaRepository casaRepository() {
            return Mockito.mock(CasaRepository.class);
        }
    }

    @Autowired
    private CasaRepository casaRepository;

    @Test
    void testCrearCasa() throws Exception {
        Casa casa = new Casa("Madriguera");
        casa.setId(1);

        Mockito.when(casaRepository.save(Mockito.any(Casa.class))).thenReturn(casa);

        mockMvc.perform(post("/casas/crear")
                        .param("nombre", "Madriguera"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Madriguera"))
                .andExpect(jsonPath("$.codigoAcceso").exists())
                .andExpect(jsonPath("$.fechaCreacion").value(LocalDate.now().toString()));
    }
}