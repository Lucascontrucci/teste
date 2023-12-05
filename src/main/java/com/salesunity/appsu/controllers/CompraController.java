package com.salesunity.appsu.controllers;

import com.salesunity.appsu.core.entities.DTO.CompraDTO;
import com.salesunity.appsu.core.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public Iterable<CompraDTO> getAllCompras(){
        return compraService.getAllCompras();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> getCompraById(@RequestParam Long id){
        return ResponseEntity.ok(compraService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CompraDTO> createCompra(@RequestBody CompraDTO compraDTO){
        return ResponseEntity.ok(compraService.createCompra(compraDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompraById(@RequestParam Long id){
        compraService.deleteCompra(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<CompraDTO> updateCompra(@RequestBody CompraDTO compraDTO){
        return ResponseEntity.ok(compraService.updateCompra(compraDTO));
    }
    
}
