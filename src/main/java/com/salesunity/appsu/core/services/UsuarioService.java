package com.salesunity.appsu.core.services;

import com.salesunity.appsu.core.entities.DTO.UsuarioDTO;
import com.salesunity.appsu.core.entities.Usuario;
import com.salesunity.appsu.core.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Iterable<UsuarioDTO> getAllUsuarios(){
        return usuarioRepository.findAll().stream().map(UsuarioDTO :: new).toList();
    }
    public UsuarioDTO getUsuarioByEmail(String email){
        Usuario usuario = usuarioRepository.findUsuarioByEmail(email).orElseThrow(() ->
                new NoSuchElementException("usuario não encontrado com o email: " +email));
        return new UsuarioDTO(usuario);
    }
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNome_usuario(usuarioDTO.getNome_usuario());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setPerfil_usuario(usuarioDTO.getPerfil_usuario());
        usuario.setCotacoes(usuarioDTO.getCotacoes());

        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }
    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findUsuarioByEmail(usuarioDTO.getEmail()).orElseThrow(() ->
                new NoSuchElementException("usuario não encontrado com email: " + usuarioDTO.getEmail()));

        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNome_usuario(usuarioDTO.getNome_usuario());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setPerfil_usuario(usuarioDTO.getPerfil_usuario());
        usuario.setCotacoes(usuarioDTO.getCotacoes());
        usuarioRepository.save(usuario);

        return new UsuarioDTO(usuario);
    }
}
