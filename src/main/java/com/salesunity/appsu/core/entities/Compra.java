package com.salesunity.appsu.core.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Compra")
public class Compra extends BaseEntity {

    private Integer quantidade;
    private Double preco_compra;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_transportadora_ID")
    private Transportadora transportadora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_cliente_ID")
    private Cliente cliente;

}
