package com.salesunity.appsu.core.entities.DTO;

import com.salesunity.appsu.core.entities.Compra;
import com.salesunity.appsu.core.entities.Fornecedor;
import com.salesunity.appsu.core.entities.Transportadora;
import com.salesunity.appsu.core.entities.valueObjects.Endereco;
import com.salesunity.appsu.core.entities.valueObjects.Telefone;
import jakarta.persistence.Embedded;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class TransportadoraDTO {

    public  TransportadoraDTO(){};

    public TransportadoraDTO(Transportadora transportadora) {
        this.id = transportadora.getId();
        this.nome_transportadora = transportadora.getNome_transportadora();
        this.email = transportadora.getEmail();
        this.endereco = transportadora.getEndereco();
        this.telefone = transportadora.getTelefone();
        this.tipos_servico = transportadora.getTipos_servico();
        for(Fornecedor fornecedor : transportadora.getFornecedores()){
           this.fornecedores_id.add(fornecedor.getId());
        }
        for(Compra compra : transportadora.getCompras()){
            this.compras_id.add(compra.getId());
        }
    }

    private Long id;
    private String nome_transportadora;
    private String email;
    private Endereco endereco;
    private Telefone telefone;
    private String tipos_servico;
    private List<Long> fornecedores_id;
    private List<Long> compras_id;

}
