package org.example.eventos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscricao;

    private String nomeParticipante;

    //pode-se usar o @Email para validar no DTO!

    private String emailParticipante;

    private String status;

    public Inscricao(){}
    @OneToMany (mappedBy = "Evento")
    List<Evento> eventos;


    //TODO: transformar em entidade e colocar relacionamento

}
