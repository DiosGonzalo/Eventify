package com.salesianostriana.eventify.Dto;

import com.salesianostriana.eventify.Models.Entrada;
import com.salesianostriana.eventify.Models.Enums.Estado;

import java.time.LocalDate;

public record EntradaDto (LocalDate fecha, Estado estado, String nombreEvento){
    public static EntradaDto of(Entrada entrada){
        return new EntradaDto(
                entrada.getFechaCompra(),
                entrada.getEstado(),
                entrada.getEvento().getNombre()
        );
    }
}
