package com.salesunity.appsu.core.entities.DTO;

import com.salesunity.appsu.core.entities.Fornecedor;
import com.salesunity.appsu.core.entities.ItemCotacao;
import com.salesunity.appsu.core.entities.Produto;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class ProdutoDTO {
    public ProdutoDTO(){};

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome_produto = produto.getNome_produto();
        this.prc_unitario = produto.getPrc_unitario();
        this.descricao_produto = produto.getDescricao_produto();
        this.unidade_medida = produto.getUnidade_medida();
        this.fornecedores = produto.getFornecedores();
        this.produto_cotacao = produto.getProduto_cotacao();
    }

    private Long id;
    private String nome_produto;
    private Double prc_unitario;
    private String descricao_produto;
    private Double unidade_medida;
    private List<Fornecedor> fornecedores;
    private List<ItemCotacao> produto_cotacao;
}
