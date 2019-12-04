package com.ditraacademy.travelagency.core.categorie;

import com.ditraacademy.travelagency.core.destination.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository  extends JpaRepository<Destination, Integer> {
}
