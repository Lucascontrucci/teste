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
@Table(name="Fornecedor")
public class Fornecedor extends BaseEntity {

    private String nome_empresa;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Telefone telefone;

    private String categoria_prd_fornecidos;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "fornecedor_produto",
            joinColumns = @JoinColumn(name = "FK_fornecedor_id"),
            inverseJoinColumns = @JoinColumn(name="FK_produto_id")
    )
    private List<Produto> produtos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "fornecedor_transportadora",
            joinColumns = @JoinColumn(name = "FK_fornecedor_id"),
            inverseJoinColumns = @JoinColumn(name="FK_transportadora_id")
    )
    private List<Transportadora> transportadoras;


    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Cotacao> cotacoes;


}
