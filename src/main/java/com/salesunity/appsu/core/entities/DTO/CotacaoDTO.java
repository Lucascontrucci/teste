package com.salesunity.appsu.core.entities.DTO;

import com.salesunity.appsu.core.entities.Cotacao;
import com.salesunity.appsu.core.entities.Fornecedor;
import com.salesunity.appsu.core.entities.ItemCotacao;
import com.salesunity.appsu.core.entities.Usuario;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Data

public class CotacaoDTO {

    public CotacaoDTO(){};

    public CotacaoDTO(Cotacao cotacao) {
        this.id = cotacao.getId();
        this.status_cotacao = cotacao.getStatus_cotacao();
        this.data_cotacao = cotacao.getData_cotacao();
        this.produto_cotacao = cotacao.getProduto_cotacao();
        this.fornecedor = cotacao.getFornecedor();
        this.usuario = cotacao.getUsuario();
    }

    private Long id;
    private String status_cotacao;
    private Date data_cotacao;
    private List<ItemCotacao> produto_cotacao;
    private Fornecedor fornecedor;
    private Usuario usuario;
}
