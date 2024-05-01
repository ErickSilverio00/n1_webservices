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
@Table(name = "CURSO")
public class Curso {

    public void interfaceFluente() {
        Curso xpto = Curso.builder().codigo(0).descricao("").build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer codigo;

    @Column(name = "DESCRICAO", length = 50, nullable = false)
    private String descricao;
}