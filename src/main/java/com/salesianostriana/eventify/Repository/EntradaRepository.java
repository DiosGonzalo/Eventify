package com.salesianostriana.eventify.Repository;

import com.salesianostriana.eventify.Models.Evento;
import com.salesianostriana.eventify.Models.Entrada;
import com.salesianostriana.eventify.Models.Enums.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
@Repository
public interface EntradaRepository extends JpaRepository<Entrada,Long> {
    List<Entrada> findByAsistenteAndEstado(Estado estado, Evento asistente);

    @EntityGraph(attributePaths = {"Asistente"})
    @Query("""
           SELECT e 
           FROM Entrada e 
           JOIN FETCH e.asistente 
           WHERE e.evento.id = :eventoId 
           AND e.estado = :estado
           """)
    Page<Entrada> findEntradasActivasPorEvento(
            @Param("eventoId") Long eventoId,
            @Param("estado") Estado estado,
            Pageable pageable);
}



}
