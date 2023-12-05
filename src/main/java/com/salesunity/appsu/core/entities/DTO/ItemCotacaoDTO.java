package com.salesunity.appsu.core.entities.DTO;

import com.salesunity.appsu.core.entities.Cotacao;
import com.salesunity.appsu.core.entities.ItemCotacao;
import com.salesunity.appsu.core.entities.Produto;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Data
public class ItemCotacaoDTO {

    public ItemCotacaoDTO(){};

    public ItemCotacaoDTO(ItemCotacao itemCotacao) {
        this.id = itemCotacao.getId();
        this.qtd_solicitada = itemCotacao.getQtd_solicitada();
        this.prc_cotado = itemCotacao.getPrc_cotado();
        this.produto_id = itemCotacao.getProduto().getId();
        this.cotacao_id = itemCotacao.getCotacao().getId();
    }

    public ItemCotacaoDTO(UUID id, Integer qtd_solicitada, Double prc_cotado) {
        this.id = id;
        this.qtd_solicitada = qtd_solicitada;
        this.prc_cotado = prc_cotado;
    }

    private UUID id;
    private Integer qtd_solicitada;
    private Double prc_cotado;
    private Long produto_id;
    private Long cotacao_id;

}
