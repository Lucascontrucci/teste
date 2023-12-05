package com.salesunity.appsu;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesunity.appsu.controllers.ItemCotacaoController;
import com.salesunity.appsu.core.entities.DTO.ItemCotacaoDTO;
import com.salesunity.appsu.core.services.ItemCotacaoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@WebMvcTest(ItemCotacaoController.class)
public class ItemCotacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemCotacaoService itemCotacaoService;

    @InjectMocks
    private ItemCotacaoController itemCotacaoController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getItemCotacaoById_ReturnsOk() throws Exception {

        UUID itemId = UUID.randomUUID();
        when(itemCotacaoService.getItemCotacaoById(itemId)).thenReturn(new ItemCotacaoDTO(itemId, 10, 20.0));


        mockMvc.perform(get("/api/v1/itemcotacao/{id}", itemId)
                        .param("id", itemId.toString()))  // Adicionando o parâmetro na URL
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(itemId.toString()))
                .andExpect(jsonPath("$.qtd_solicitada").value(10))
                .andExpect(jsonPath("$.prc_cotado").value(20.0));
    }

    @Test
    public void createItemCotacao_ReturnsOk() throws Exception {
        UUID itemId = UUID.randomUUID();
        when(itemCotacaoService.createItemCotacao(any(ItemCotacaoDTO.class))).thenReturn(new ItemCotacaoDTO(itemId, 10, 20.0));

        // Performing the request and asserting the response
        mockMvc.perform(post("/api/v1/itemcotacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new ItemCotacaoDTO(itemId, 10, 20.0))))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteItemCotacaoById_ReturnsOk() throws Exception {
        UUID itemId = UUID.randomUUID();

        // Mocking the service response for the delete operation
        doNothing().when(itemCotacaoService).deleteItemCotacao(itemId);

        mockMvc.perform(delete("/api/v1/itemcotacao/{id}", itemId))
                .andExpect(status().isNoContent());
    }

}
