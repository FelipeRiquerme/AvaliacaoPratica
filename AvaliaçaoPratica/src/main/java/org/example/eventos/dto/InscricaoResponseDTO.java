package org.example.eventos.dto;

public record InscricaoResponseDTO(
       String  nomeParticipante,
       String emailParticipante,
       String Status,
       Long eventoId

) {


}
