package org.example.eventos.service;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.example.eventos.dto.EventoRequestDTO;
import org.example.eventos.dto.EventoResponseDTO;
import org.example.eventos.dto.InscricaoRequestDTO;
import org.example.eventos.dto.InscricaoResponseDTO;
import org.example.eventos.exception.RecursoNaoEncontradoException;
import org.example.eventos.model.Evento;
import org.example.eventos.model.Inscricao;
import org.example.eventos.model.LocalEvento;
import org.example.eventos.repository.EventoRepository;
import org.example.eventos.repository.InscricaoRepository;
import org.example.eventos.repository.LocalEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private LocalEventoRepository localEventoRepository

    public List<EventoResponseDTO> listarTodos() {
        return eventoRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }
    public EventoResponseDTO buscarPorId(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrada"));

        return converterParaResponse(evento);
    }
    public EventoResponseDTO cadastrar(InscricaoRequestDTO dto) {
        LocalEvento localEvento = localEventoRepository.findById(dto.eventoId()).orElseThrow(() -> new RuntimeException("Id não encontrado"));

        Evento evento1 = new Evento();
        evento1.setNome(dto.Nome());
        evento1.setDescricao(dto.Descricao);
        evento1.setDataEvento(dto.DataEvento);
        evento1.setValorIngresso(dto.ValorIngresso);


        Evento salva = eventoRepository.save(evento1);

        return converterParaResponse(salva);
    }
    private EventoResponseDTO converterParaResponse(Evento evento) {
        return new EventoResponseDTO(
              evento.getIdEvento(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getDataEvento(),
                evento.getValorIngresso(),
                evento.getLocalId()


                );
    }

    public EventoResponseDTO atualizar(Long id, EventoRequestDTO dto) {
        Evento evento = eventoRepository.findById(dto.eventoId()).orElseThrow(() ->new RuntimeException("Id não encontrado"));

    }
    public void deletar(Long id) {
        Evento evento = eventoRepository.findById(id).orElseThrow(()-> new RuntimeException("Id não encontrado"));
        eventoRepository.deleteById(id);
    }

    public List<EventoResponseDTO> listarPorLocal(Long idLocal) {
        return eventoRepository.findByLocalEventoId(idLocal)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }
}