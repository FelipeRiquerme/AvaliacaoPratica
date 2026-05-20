package org.example.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.eventos.dto.*;
import org.example.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Locais", description = "Rotas para gerenciamento de Locais")
@RestController
@RequestMapping("/locais")
public class LocalEventoController {

    @Autowired
    private EventoService service;

    @Operation(summary = "Lista todos os locais")
    @GetMapping
    public List<LocalEventoResponseDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Busca um local por id")
    @GetMapping("/{idEvento}")
    public LocalEventoResponseDTO buscarPorId(@PathVariable Long idEvento) {
        return service.buscarPorId(idEvento);
    }

    @Operation(summary = "Cadastra um novo local")
    @PostMapping
    public LocalEventoResponseDTO cadastrar(@RequestBody @Valid LocalEventoRequestDTO dto) {

        return service.cadastrar(dto);
    }

    @Operation(summary = "Atualiza um local existente")
    @PutMapping("/{idEvento}")
    public LocalEventoResponseDTO atualizar(@PathVariable Long idLocal, @RequestBody LocalEventoResponseDTO dto) {
        return service.atualizar(idLocal, dto);
    }

    @Operation(summary = "Remove um local")
    @DeleteMapping("/{idEvento}")
    public void deletar(@PathVariable Long idLocal) {
        service.deletar(idLocal);
    }




}

