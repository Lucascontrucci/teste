package com.salesunity.appsu.core.entities.DTO;

import com.salesunity.appsu.core.entities.Cotacao;
import com.salesunity.appsu.core.entities.Usuario;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class UsuarioDTO {
    public UsuarioDTO(){};

    public UsuarioDTO(Usuario usuario) {
        this.email = usuario.getEmail();
        this.nome_usuario = usuario.getNome_usuario();
        this.senha = usuario.getSenha();
        this.perfil_usuario = usuario.getPerfil_usuario();
        this.cotacoes = usuario.getCotacoes();
    }
    public UsuarioDTO(String email, String nome_usuario, String perfil_usuario){
        this.email = email;
        this.nome_usuario = nome_usuario;
        this.perfil_usuario = perfil_usuario;
    }
    private String email;
    private String nome_usuario;
    private String senha;
    private String perfil_usuario;
    private List<Cotacao> cotacoes;
}
