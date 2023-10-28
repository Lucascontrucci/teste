package com.salesunity.appsu.core.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Produto")
public class Produto extends BaseEntity {

    private String nome_produto;

    private Double prc_unitario;

    private String descricao_produto;

    private Double unidade_medida;

    @ManyToMany(mappedBy = "produtos",fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Fornecedor> fornecedores;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Orcamento> produto_cotacao;


}
