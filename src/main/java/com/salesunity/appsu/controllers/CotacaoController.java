package com.salesunity.appsu.controllers;

import com.salesunity.appsu.core.entities.DTO.CotacaoDTO;
import com.salesunity.appsu.core.services.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoService cotacaoService;

    @GetMapping
    public Iterable<CotacaoDTO> getAllCotacaos(){
        return cotacaoService.getAllCotacaos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CotacaoDTO> getCotacaoById(@RequestParam Long id){
        return ResponseEntity.ok(cotacaoService.getCotacaoById(id));
    }

    @PostMapping
    public ResponseEntity<CotacaoDTO> createCotacao(@RequestBody CotacaoDTO cotacaoDTO){
        return ResponseEntity.ok(cotacaoService.createCotacao(cotacaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCotacaoById(@RequestParam Long id){
        cotacaoService.deleteCotacao(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<CotacaoDTO> updateCotacao(@RequestBody CotacaoDTO cotacaoDTO){
        return ResponseEntity.ok(cotacaoService.updateCotacao(cotacaoDTO));
    }
    
}
