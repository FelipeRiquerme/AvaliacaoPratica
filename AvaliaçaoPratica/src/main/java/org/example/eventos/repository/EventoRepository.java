package org.example.eventos.repository;

import org.example.eventos.model.Evento;
import org.example.eventos.model.LocalEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    // TODO: criar método para filtrar eventos pelo nome.
    List<Evento> findyByNomeContainingIgnoreCase(String nome);

    List<Evento> findyByEventoId(Long idEvento);

    List<LocalEvento> findByLocalEventoId(Long idLocal);
    //TODO: criar método para listar eventos de um determinado local.

}
