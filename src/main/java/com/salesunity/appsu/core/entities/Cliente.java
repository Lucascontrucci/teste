package com.salesunity.appsu.core.entities;

import com.salesunity.appsu.core.entities.valueObjects.Endereco;
import com.salesunity.appsu.core.entities.valueObjects.Telefone;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Cliente")
public class Cliente {

    @Id
    @Column(length = 50)
    private String email;

    private String nome_cliente;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Telefone telefone;

    private String historico;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Compra> compras;

}
