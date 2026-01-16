package com.salesianostriana.eventify.Dto;

import com.salesianostriana.eventify.Models.Asistente;
import com.salesianostriana.eventify.Models.Entrada;
import com.salesianostriana.eventify.Models.Enums.Estado;
import com.salesianostriana.eventify.Models.Evento;

import java.time.LocalDate;

public record CreateEntradaRequest(LocalDate fecha,
                                   Estado estado,
                                   Evento evento,
                                   Asistente asistente) {
    public Entrada toEntity(CreateEntradaRequest dto){
        return new Entrada().builder()
                .estado(dto.estado)
                .evento(dto.evento)
                .fechaCompra(dto.fecha)
                .asistente(dto.asistente)
                .build();
    }
}
