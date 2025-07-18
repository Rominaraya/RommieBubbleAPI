package com.rommiebubble.controllers;

import com.rommiebubble.entities.Casa;
import com.rommiebubble.entities.Usuario;
import com.rommiebubble.services.CasaService;
import com.rommiebubble.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class ServiceConfig {
        @Bean
        public UsuarioService usuarioService() {
            return Mockito.mock(UsuarioService.class);
        }

        @Bean
        public CasaService casaService() {
            return Mockito.mock(CasaService.class);
        }
    }

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CasaService casaService;

    @Test
    void testCrearUsuario() throws Exception {
        // Simular casa existente en la base
        Casa casa = new Casa("Madriguera");
        casa.setId(1);

        // Simular usuario a crear
        Usuario usuario = new Usuario("Romi", "romi@example.com", casa);

        // Mocks necesarios
        Mockito.when(casaService.buscarPorId(1)).thenReturn(casa);
        Mockito.when(usuarioService.crearUsuario("Romi", "romi@example.com", casa)).thenReturn(usuario);

        // Ejecutar petición POST y validar respuesta
        mockMvc.perform(post("/usuarios/crear")
                        .param("nombre", "Romi")
                        .param("email", "romi@example.com")
                        .param("casaId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Romi"))
                .andExpect(jsonPath("$.email").value("romi@example.com"))
                .andExpect(jsonPath("$.casa.nombre").value("Madriguera"));
    }
}