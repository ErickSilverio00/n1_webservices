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
@Table(name = "AVALIACAO")
public class Avaliacao {

    public void interfaceFluente() {
        Avaliacao xpto = Avaliacao.builder().nota1(nota1).nota2(nota2).notaProvaFinal(notaProvaFinal).frequencia(0)
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float nota1;

    private Float nota2;

    private Float notaProvaFinal;

    private Integer frequencia;
}