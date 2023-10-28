package com.salesunity.appsu.core.services;

import com.salesunity.appsu.core.entities.Usuario;
import com.salesunity.appsu.core.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Iterable<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }
    public Optional<Usuario> getUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }
    public void createUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

}
