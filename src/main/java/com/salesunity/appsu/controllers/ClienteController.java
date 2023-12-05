package com.salesunity.appsu.controllers;

import com.salesunity.appsu.core.entities.DTO.ClienteDTO;
import com.salesunity.appsu.core.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public Iterable<ClienteDTO> getAllClientes(){
        return clienteService.getAllClientes();
    }
    @GetMapping("/{email}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable String email){
        return ResponseEntity.ok(clienteService.getClienteByEmail(email));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.createCliente(clienteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<ClienteDTO> updateCliente(@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.updateCliente(clienteDTO));
    }
    
}
