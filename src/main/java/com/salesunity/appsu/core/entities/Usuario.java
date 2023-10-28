package com.salesunity.appsu.core.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="Usuario")
public class Usuario {

    @Id
    @Column(length = 50)
    private String email;

    private String nome_usuario;

    private String senha;

    private String perfil_usuario;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Cotacao> cotacoes;




    public Usuario(String email, String nome_usuario, String senha, String perfil_usuario) {
        this.email = email;
        this.nome_usuario = nome_usuario;
        this.senha = senha;
        this.perfil_usuario = perfil_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }
}
