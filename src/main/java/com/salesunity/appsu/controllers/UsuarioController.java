package com.salesunity.appsu.controllers;

import com.salesunity.appsu.core.entities.DTO.UsuarioDTO;
import com.salesunity.appsu.core.entities.Usuario;
import com.salesunity.appsu.core.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Iterable<UsuarioDTO> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
    @GetMapping("/{email}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable String email){
        return ResponseEntity.ok(usuarioService.getUsuarioByEmail(email));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.createUsuario(usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.updateUsuario(usuarioDTO));
    }

}
