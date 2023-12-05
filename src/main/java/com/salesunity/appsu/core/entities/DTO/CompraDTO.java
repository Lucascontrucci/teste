package com.salesunity.appsu.core.entities.DTO;

import com.salesunity.appsu.core.entities.Cliente;
import com.salesunity.appsu.core.entities.Compra;
import com.salesunity.appsu.core.entities.Transportadora;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CompraDTO {

    public CompraDTO(){};

    public CompraDTO(Compra compra) {
        this.id = compra.getId();
        this.quantidade = compra.getQuantidade();
        this.preco_compra = compra.getPreco_compra();
        this.transportadora = compra.getTransportadora();
        this.email_cliente = compra.getCliente().getEmail();
    }
    private Long id;
    private Integer quantidade;
    private Double preco_compra;
    private Transportadora transportadora;
    private String email_cliente;
}
