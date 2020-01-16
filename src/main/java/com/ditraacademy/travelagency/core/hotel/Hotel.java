package com.ditraacademy.travelagency.core.hotel;

import com.ditraacademy.travelagency.core.chambre.Chambre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String adresse;
    private int telephone;
    private int etoiles;
    private String description;
    @ManyToMany
    private List<Chambre> chambres;

}
