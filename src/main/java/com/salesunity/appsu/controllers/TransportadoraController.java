package com.salesunity.appsu.controllers;


import com.salesunity.appsu.core.entities.DTO.TransportadoraDTO;
import com.salesunity.appsu.core.services.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transportadora")
public class TransportadoraController {

    @Autowired
    private TransportadoraService transportadoraService;

    @GetMapping
    public Iterable<TransportadoraDTO> getAllTransportadoras(){
        return transportadoraService.getAllTransportadoras();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransportadoraDTO> getTransportadoraById(@RequestParam Long id){
        return ResponseEntity.ok(transportadoraService.getTransportadoraById(id));
    }

    @PostMapping
    public ResponseEntity<TransportadoraDTO> createTransportadora(@RequestBody TransportadoraDTO transportadoraDTO){
        return ResponseEntity.ok(transportadoraService.createTransportadora(transportadoraDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransportadoraById(@RequestParam Long id){
        transportadoraService.deleteTransportadora(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<TransportadoraDTO> updateTransportadora(@RequestBody TransportadoraDTO transportadoraDTO){
        return ResponseEntity.ok(transportadoraService.updateTransportadora(transportadoraDTO));
    }
    
}
