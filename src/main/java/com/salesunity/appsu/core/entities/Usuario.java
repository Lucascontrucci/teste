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

}
