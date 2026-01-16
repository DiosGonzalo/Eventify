package com.salesianostriana.eventify.Services;

import com.salesianostriana.eventify.Models.Asistente;
import com.salesianostriana.eventify.Models.Entrada;
import com.salesianostriana.eventify.Models.Enums.Estado;
import com.salesianostriana.eventify.Models.Evento;
import com.salesianostriana.eventify.Repository.AsistenteRepository;
import com.salesianostriana.eventify.Repository.EntradaRepository;
import com.salesianostriana.eventify.Repository.EventoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class EntradaService {
    private final EntradaRepository entradaRepository;
    private final EventoRepository eventoRepository;
    private final AsistenteRepository asistenteRepository;

    public Page<Entrada> entradasEvento(Pageable pageable, Long idEvento) {

        return entradaRepository.findEntradasActivasPorEvento(idEvento, Estado.ACTIVA, pageable);


    }

    public Entrada comprarEntrada(Long idEvento, Long idAsistente, LocalDate fecha){
       Evento evento = eventoRepository.findById(idEvento).orElseThrow(RuntimeException::new);
       Asistente asistente = asistenteRepository.findById(idAsistente).orElseThrow(RuntimeException::new);
        if(evento.getEntradasVendidas()> evento.getAforoMaximo()){
            throw new RuntimeException("Mas entradas que capacidad");
        }
        evento.setEntradasVendidas(evento.getEntradasVendidas()+1);
        return new Entrada().builder()
                .fechaCompra(fecha)
                .asistente(asistente)
                .estado(Estado.ACTIVA)
                .build();
    }

    public void cacelarEntrada(Long idEntrada){
        Entrada entrada = entradaRepository.findById(idEntrada).orElseThrow(RuntimeException::new);
        entrada.getEvento().setEntradasVendidas(entrada.getEvento().getEntradasVendidas()-1);

        entrada.setEstado(Estado.CANCELADA);
    }
}


