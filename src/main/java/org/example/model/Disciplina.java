package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DISCIPLINA")
public class Disciplina {

    public void interfaceFluente() {
        Disciplina xpto = Disciplina.builder().codigo(0).descricao("").cargaHoraria(0).ementa("").bibliografia("")
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer codigo;

    @Column(name = "DESCRICAO", length = 50, nullable = false)
    private String descricao;

    private Integer cargaHoraria;

    private String ementa;

    private String bibliografia;
}