package com.salesunity.appsu.core.entities.DTO;

import com.salesunity.appsu.core.entities.Cliente;
import com.salesunity.appsu.core.entities.Compra;
import com.salesunity.appsu.core.entities.valueObjects.Endereco;
import com.salesunity.appsu.core.entities.valueObjects.Telefone;
import jakarta.persistence.Embedded;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class ClienteDTO {

    public ClienteDTO(){};
    public ClienteDTO(Cliente cliente) {
        this.email = cliente.getEmail();
        this.nome_cliente = cliente.getNome_cliente();
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
        this.historico = cliente.getHistorico();
        this.compras = cliente.getCompras();
    }

    private String email;
    private String nome_cliente;
    private Endereco endereco;
    private Telefone telefone;
    private String historico;
    private List<Compra> compras;

}
