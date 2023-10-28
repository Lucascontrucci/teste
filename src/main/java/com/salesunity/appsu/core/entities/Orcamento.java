package com.salesunity.appsu.core.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="Orcamento")
public class Orcamento {

    @Id
    @GeneratedValue
    private UUID id;

    private Integer qtd_solicitada;
    private Double prc_cotado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_produto_ID")
    private Produto produto;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_cotacao_ID")
    private Cotacao cotacao;

}

