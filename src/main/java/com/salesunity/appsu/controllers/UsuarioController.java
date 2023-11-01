package com.salesunity.appsu.controllers;

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
    public Iterable<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
    @GetMapping("/{id}")
    public void getUsuarioById(@RequestParam Long id){
        usuarioService.getUsuarioById(id);
    }


    @PostMapping
    public void createUsuario(@RequestBody Usuario usuario){
        usuarioService.createUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuarioById(@RequestParam Long id){
        usuarioService.deleteUsuario(id);
    }

}
