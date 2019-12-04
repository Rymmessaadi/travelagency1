package com.ditraacademy.travelagency.core.chambre;

import com.ditraacademy.travelagency.core.voyage.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Voyage, Integer> {
}
