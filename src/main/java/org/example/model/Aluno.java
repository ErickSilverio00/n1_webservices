package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*lombok*/
@Data // lomok ajuda com os métodos: get,set,tostring, @equals
@Builder
@NoArgsConstructor
@AllArgsConstructor
/* lombok */
/* jpa/hibernate */
@Entity
@Table(name = "ALUNO")
/* jpa/hibernate */
public class Aluno {

    public void interfaceFluente() {
        Aluno xpto = Aluno.builder().nome("").endereco("").telefone("").build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    private String endereco;

    private String telefone;

    private String matricula;

    private boolean ativo;

}