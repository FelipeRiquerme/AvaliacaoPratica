package org.example.eventos.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record InscricaoRequestDTO(

        @NotBlank
        String nomeParticipante,
        @Email
        String emailParticipante,
        @NotBlank
        String Status,
        Long eventoId


        ){

}
