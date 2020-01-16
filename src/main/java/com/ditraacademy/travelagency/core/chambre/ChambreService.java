package com.ditraacademy.travelagency.core.chambre;

import com.ditraacademy.travelagency.core.categorie.Categorie;
import com.ditraacademy.travelagency.core.categorie.CategorieRepository;
import com.ditraacademy.travelagency.core.type.Type;
import com.ditraacademy.travelagency.core.type.TypeRepository;

import com.ditraacademy.travelagency.core.voyage.Voyage;
import com.ditraacademy.travelagency.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {
    @Autowired
    ChambreRepository chambreRepository ;

    @Autowired
    TypeRepository typeRepository;
    @Autowired
    CategorieRepository categorieRepository;

    public ResponseEntity<?> getAllChambre() {
       List<Chambre> chambres= chambreRepository.findAll();
        return  new ResponseEntity<>(chambres, HttpStatus.OK) ;
    }

    public ResponseEntity<?> addChambre(Chambre chambre) {

        Optional<Type> typeOptional = typeRepository.findById(chambre.getType().getId());

        if (!typeOptional.isPresent())
            return new ResponseEntity<>(new ErrorResponseModel("Invalid type "), HttpStatus.BAD_REQUEST);

        Optional<Categorie> categorieOptional = categorieRepository.findById(chambre.getCategorie().getId());
        if (!categorieOptional.isPresent())
            return new ResponseEntity<>(new ErrorResponseModel("Invalid categorie id"), HttpStatus.BAD_REQUEST);
        Optional<Chambre> chambreOptional = chambreRepository.findByCategorieAndType(chambre.getCategorie(),chambre.getType());
        if(chambreOptional.isPresent())
            return new ResponseEntity<>(new ErrorResponseModel("chambre existe"),HttpStatus.BAD_REQUEST);//exisistance de chambre





        chambre = chambreRepository.save(chambre);

        return new ResponseEntity<>(chambre,HttpStatus.OK);
    }

}
