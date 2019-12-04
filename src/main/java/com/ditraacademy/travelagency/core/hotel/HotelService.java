package com.ditraacademy.travelagency.core.hotel;

import com.ditraacademy.travelagency.core.chambre.Chambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public ResponseEntity<?> addHotel(Hotel hotel) {
        hotel= hotelRepository.save(hotel);
        return  new ResponseEntity<>(hotel,HttpStatus.OK);
    }


    public ResponseEntity<?> getAllHotel() {
        List<Hotel> hotels = hotelRepository.findAll();
        return  new  ResponseEntity<>(hotels ,HttpStatus.OK) ;
    }
}
