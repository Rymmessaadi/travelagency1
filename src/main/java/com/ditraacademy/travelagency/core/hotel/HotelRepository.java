package com.ditraacademy.travelagency.core.hotel;

import com.ditraacademy.travelagency.core.voyage.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Voyage, Integer> {
}
