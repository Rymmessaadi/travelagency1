package com.ditraacademy.travelagency.core.chambre;



import com.ditraacademy.travelagency.core.categorie.Categorie;
import com.ditraacademy.travelagency.core.destination.Destination;
import com.ditraacademy.travelagency.core.hotel.Hotel;
import com.ditraacademy.travelagency.core.type.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//composé type et catégorie=chambre
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Categorie categorie;
    @JsonIgnore
    @ManyToMany(mappedBy = "chambres")
    private List<Hotel> hotels;
}
