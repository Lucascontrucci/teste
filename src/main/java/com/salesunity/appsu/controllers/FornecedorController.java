package com.salesunity.appsu.controllers;

import com.salesunity.appsu.core.entities.DTO.FornecedorDTO;
import com.salesunity.appsu.core.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public Iterable<FornecedorDTO> getAllFornecedors(){
        return fornecedorService.getAllFornecedors();
    }
    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> getFornecedorById(@PathVariable Long id){
        return ResponseEntity.ok(fornecedorService.getFornecedorById(id));
    }

    @PostMapping
    public ResponseEntity<FornecedorDTO> createFornecedor(@RequestBody FornecedorDTO fornecedorDTO){
        return ResponseEntity.ok(fornecedorService.createFornecedor(fornecedorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedorById(@PathVariable Long id){
        fornecedorService.deleteFornecedor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<FornecedorDTO> updateFornecedor(@RequestBody FornecedorDTO fornecedorDTO){
        return ResponseEntity.ok(fornecedorService.updateFornecedor(fornecedorDTO));
    }
    
}
