package com.ditraacademy.travelagency.core.voyage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoyageRepository extends JpaRepository<Voyage, Integer> {

    List<Voyage> findAllByPrixIsLessThanEqual(double prix );
    List<Voyage> findAllByPrixIsLessThanEqualAndNbPlacesNot(double prix ,int nbPlaces);
}
