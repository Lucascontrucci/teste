package com.salesunity.appsu.controllers;

import com.salesunity.appsu.core.entities.DTO.ItemCotacaoDTO;
import com.salesunity.appsu.core.services.ItemCotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/api/v1/itemcotacao")
public class ItemCotacaoController {

    @Autowired
    private ItemCotacaoService itemcotacaoService;

    @GetMapping
    public Iterable<ItemCotacaoDTO> getAllItemCotacaos(){
        return itemcotacaoService.getAllItemCotacaos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ItemCotacaoDTO> getItemCotacaoById(@PathVariable UUID id){
        return ResponseEntity.ok(itemcotacaoService.getItemCotacaoById(id));
    }

    @PostMapping
    public ResponseEntity<ItemCotacaoDTO> createItemCotacao(@RequestBody ItemCotacaoDTO itemcotacaoDTO){
        return ResponseEntity.ok(itemcotacaoService.createItemCotacao(itemcotacaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemCotacaoById(@PathVariable UUID id){
        itemcotacaoService.deleteItemCotacao(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<ItemCotacaoDTO> updateItemCotacao(@RequestBody ItemCotacaoDTO itemcotacaoDTO){
        return ResponseEntity.ok(itemcotacaoService.updateItemCotacao(itemcotacaoDTO));
    }
    
}
