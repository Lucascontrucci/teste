package com.salesunity.appsu.core.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="Orcamento")
public class ItemCotacao {

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

