package com.salesianostriana.eventify.Repository;

import com.salesianostriana.eventify.Models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenteRepository extends JpaRepository<Evento, Long> {
}
