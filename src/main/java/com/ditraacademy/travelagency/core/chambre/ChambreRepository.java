package com.ditraacademy.travelagency.core.chambre;

import com.ditraacademy.travelagency.core.categorie.Categorie;
import com.ditraacademy.travelagency.core.type.Type;
import com.ditraacademy.travelagency.core.voyage.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
    Optional<Chambre> findByCategorieAndType(Categorie categorie, Type type);
}
