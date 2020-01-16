package com.ditraacademy.travelagency.core.categorie;

import com.ditraacademy.travelagency.core.destination.Destination;
import com.ditraacademy.travelagency.core.type.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository  extends JpaRepository<Categorie, Integer> {
}
