package com.ditraacademy.travelagency.core.hotel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {
    @Autowired
    HotelService hotelService;
    @GetMapping("/hotels")
    public ResponseEntity<?> getAllHotel ( ){
        return hotelService.getAllHotel ( );
    }

    @PostMapping("/hotel")
    public ResponseEntity <?> AddChambre(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }}




