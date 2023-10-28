package com.salesunity.appsu.core.entities.valueObjects;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Telefone {
    @Column(name="telefone_ddd")
    private String ddd;
    @Column(name = "telefone_numero")
    private String numero;
}
