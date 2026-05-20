package org.example.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.eventos.dto.EventoRequestDTO;
import org.example.eventos.dto.EventoResponseDTO;
import org.example.eventos.dto.InscricaoRequestDTO;
import org.example.eventos.dto.InscricaoResponseDTO;
import org.example.eventos.service.EventoService;
import org.example.eventos.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Inscricoes", description = "Rotas para gerenciamento de inscrições")

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    @Autowired
    private InscricaoService service;

    @Operation(summary = "Lista todas as inscrições")
    @GetMapping
    public List<InscricaoResponseDTO> listar() {
        return service.listarTodas();
    }

    @Operation(summary = "Busca uma inscrição por id")
    @GetMapping("/{idInscricao}")
    public InscricaoResponseDTO buscarPorId(@PathVariable Long idEvento) {
        return service.buscarPorId(idEvento);
    }

    @Operation(summary = "Cadastra uma nova inscrição")
    @PostMapping
    public InscricaoResponseDTO cadastrar(@RequestBody @Valid InscricaoRequestDTO dto) {

        return service.cadastrar(dto);
    }

    @Operation(summary = "Atualiza uma Inscrição existente")
    @PutMapping("/{idInscricao}")
    public InscricaoResponseDTO atualizar(@PathVariable Long idInscricao, @RequestBody InscricaoRequestDTO dto) {
        return service.atualizar(idInscricao, dto);
    }

    @Operation(summary = "Remove uma Inscrição")
    @DeleteMapping("/{idInscricao}")
    public void deletar(@PathVariable Long idInscricao) {
        service.deletar(idInscricao);
    }


}
