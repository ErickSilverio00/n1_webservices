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
@Table(name = "TURMA")
public class Turma {

    public void interfaceFluente() {
        Turma xpto = Turma.builder().ano(0).semestre(0).diaSemana(0).horarios("").build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer ano;

    private Integer semestre;

    private Integer diaSemana;

    @Column(name = "HORARIOS", length = 50, nullable = false)
    private String horarios;
}