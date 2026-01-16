package com.salesianostriana.eventify.Controller;

import com.salesianostriana.eventify.Services.EntradaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {
 public static EntradaService entradaService;
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarEntrada(@PathVariable Long id) {
        entradaService.cacelarEntrada(id);
        return ResponseEntity.noContent().build();
    }
}
