package com.salesunity.appsu.core.entities;

import com.salesunity.appsu.core.entities.valueObjects.Endereco;
import com.salesunity.appsu.core.entities.valueObjects.Telefone;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Transportadora")
public class Transportadora extends BaseEntity {

    private String nome_transportadora;

    private String email;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Telefone telefone;

    private String tipos_servico;

    @ManyToMany(mappedBy = "transportadoras",fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Fornecedor> fornecedores;


    @OneToMany(mappedBy = "transportadora", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Compra> compras;
}

