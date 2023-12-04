package com.salesunity.appsu.core.entities.DTO;

import com.salesunity.appsu.core.entities.Cotacao;
import com.salesunity.appsu.core.entities.Fornecedor;
import com.salesunity.appsu.core.entities.Produto;
import com.salesunity.appsu.core.entities.Transportadora;
import com.salesunity.appsu.core.entities.valueObjects.Endereco;
import com.salesunity.appsu.core.entities.valueObjects.Telefone;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

public class FornecedorDTO {

    public FornecedorDTO(){};

    public FornecedorDTO(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.nome_empresa = fornecedor.getNome_empresa();
        this.endereco = fornecedor.getEndereco();
        this.telefone = fornecedor.getTelefone();
        this.categoria_prd_fornecidos = fornecedor.getCategoria_prd_fornecidos();
        this.produtos = fornecedor.getProdutos();
        this.transportadoras = fornecedor.getTransportadoras();
        this.cotacoes = fornecedor.getCotacoes();
    }

    private Long id;
    private String nome_empresa;
    private Endereco endereco;
    private Telefone telefone;
    private String categoria_prd_fornecidos;
    private List<Produto> produtos;
    private List<Transportadora> transportadoras;
    private List<Cotacao> cotacoes;

}
