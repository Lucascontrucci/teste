package com.salesunity.appsu.controllers;

import com.salesunity.appsu.core.entities.DTO.ProdutoDTO;
import com.salesunity.appsu.core.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Iterable<ProdutoDTO> getAllProdutos(){
        return produtoService.getAllProdutos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.getProdutoById(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduto(@RequestBody ProdutoDTO produtoDTO){
        return ResponseEntity.ok(produtoService.createProduto(produtoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdutoById(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<ProdutoDTO> updateProduto(@RequestBody ProdutoDTO produtoDTO){
        return ResponseEntity.ok(produtoService.updateProduto(produtoDTO));
    }
    
}
