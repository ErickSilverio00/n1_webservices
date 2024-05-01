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
@Table(name = "PROFESSOR")
public class Professor {

    public void interfaceFluente() {
        Professor xpto = Professor.builder().nome("").endereco("").telefone("").build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    private String endereco;

    private String telefone;

    private Boolean titulacaoMaxima;
}