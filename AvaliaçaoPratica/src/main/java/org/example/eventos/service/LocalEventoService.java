package org.example.eventos.service;

import org.example.eventos.dto.EventoResponseDTO;
import org.example.eventos.dto.InscricaoRequestDTO;
import org.example.eventos.exception.RecursoNaoEncontradoException;
import org.example.eventos.model.Evento;
import org.example.eventos.model.LocalEvento;
import org.example.eventos.repository.InscricaoRepository;
import org.example.eventos.repository.LocalEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalEventoService {
    @Autowired
    private LocalEventoRepository localEventoRepository;

    public List<EventoResponseDTO> listarTodos() {
        return localEventoRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }
    public EventoResponseDTO buscarPorId(Long idLocal) {
        LocalEvento localEvento = localEventoRepository.findById(idLocal)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrada"));

        return converterParaResponse(localEvento);
    }
    public EventoResponseDTO cadastrar(InscricaoRequestDTO dto) {
        LocalEvento localEvento = localEventoRepository.findById(dto.eventoId()).orElseThrow(() -> new RuntimeException("Id não encontrado"));

        Local local = new Local();
        local.setNome(dto.Nome());
        local.setEndereco(dto.Endereco);
        local.setCapacidade(dto.Capacidade);



        Evento salva = localEventoRepository.save(local);

        return converterParaResponse(salva);
    }
    private EventoResponseDTO converterParaResponse(Local local) {
        return new EventoResponseDTO(
              local.getNome(),
                local.getEndereco(),
                local.getcapacidade()


        );
    }
}
