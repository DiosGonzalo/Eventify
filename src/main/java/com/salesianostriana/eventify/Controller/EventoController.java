package com.salesianostriana.eventify.Controller;

import com.salesianostriana.eventify.Models.Entrada;
import com.salesianostriana.eventify.Services.EntradaService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/api/eventos")

public class EventoController {
    private final EntradaService entradaService;


    public EventoController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }

    @GetMapping("/{id}/entradas")
    public ResponseEntity<Page<Entrada>> listarEntradasEvento(
            @PathVariable Long id,
            Pageable pageable) {

        Page<Entrada> pagina =entradaService.entradasEvento(pageable, id);
        return ResponseEntity.ok(pagina);
    }

}
