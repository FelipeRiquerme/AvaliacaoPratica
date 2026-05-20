package org.example.eventos.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record EventoRequestDTO(

        //TODO: colocar validações de entrada de dados
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        String descricao,


        LocalDate dataEvento,

        @NotNull
        @Positive
        Double valorIngresso,

        Long localId,
        @NotBlank
        String nomeParticipante,
        @Email
        String emailParticipante,
        @NotBlank
        String Status
) {
}
