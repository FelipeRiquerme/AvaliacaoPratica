package org.example.eventos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    private String nome;

    private String descricao;

    //exemplo = "2026-05-19"
    private LocalDate dataEvento;

    private Double valorIngresso;

    //TO DO: corrigir o relacionamento entre Evento e LocalEvento
    private Long localId;

    public Evento (){}
    @OneToMany(mappedBy =" LocalEvento")
    private List<LocalEvento> localEvento;

    @ManyToOne
    @JoinColumn(name = "Inscricao_id")
    private Inscricao inscricao;

}


