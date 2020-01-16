package com.ditraacademy.travelagency.core.hotel;

import com.ditraacademy.travelagency.core.chambre.Chambre;
import com.ditraacademy.travelagency.core.chambre.ChambreRepository;
import com.ditraacademy.travelagency.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired //kima import
    HotelRepository hotelRepository;
    @Autowired
    ChambreRepository chambreRepository;

    public ResponseEntity<?> addHotel(Hotel hotel) {
        for(Chambre chambre : hotel.getChambres()){
            Optional<Chambre> chambreOptional = chambreRepository.findById(chambre.getId());
            if (!chambreOptional.isPresent()){
                return new ResponseEntity<>(new ErrorResponseModel("Wrong room id" + chambre.getId()),HttpStatus.BAD_REQUEST);
            }
        }


        hotel= hotelRepository.save(hotel);
        return  new ResponseEntity<>(hotel,HttpStatus.OK);
    }


    public ResponseEntity<?> getAllHotel() {
        List<Hotel> hotels = hotelRepository.findAll();
        return  new  ResponseEntity<>(hotels ,HttpStatus.OK) ;
    }
}
