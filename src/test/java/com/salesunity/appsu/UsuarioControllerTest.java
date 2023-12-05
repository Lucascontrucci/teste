package com.salesunity.appsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesunity.appsu.controllers.UsuarioController;
import com.salesunity.appsu.core.entities.DTO.UsuarioDTO;
import com.salesunity.appsu.core.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {


    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllUsuarios_ReturnsOk() throws Exception {

        List<UsuarioDTO> usuariosMock = Arrays.asList(
                new UsuarioDTO("email1@example.com", "Nome1", "Perfil1"),
                new UsuarioDTO("email2@example.com", "Nome2", "Perfil2")
        );

        when(usuarioService.getAllUsuarios()).thenReturn(usuariosMock);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/usuario"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }
    @Test
    public void createUsuario_ReturnsOk() throws Exception {

        when(usuarioService.createUsuario(any())).thenReturn(new UsuarioDTO("email1@example.com", "Nome1", "Perfil1"));


        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new UsuarioDTO("email1@example.com", "Nome1", "Perfil1"))))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void getUsuarioById_ReturnsOk() throws Exception {
        when(usuarioService.getUsuarioByEmail(anyString())).thenReturn(new UsuarioDTO("test@example.com", "Nome2", "Perfil2"));


        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/usuario")
                        .param("email", "test@example.com"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}
