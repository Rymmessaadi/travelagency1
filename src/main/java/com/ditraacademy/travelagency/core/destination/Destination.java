package com.ditraacademy.travelagency.core.destination;

import com.ditraacademy.travelagency.core.voyage.Voyage;
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
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;

    @JsonIgnore//jsonIgnore sur l'attribut list voyage éliminé l'infini..sue chaque relation bidirectionnel on ajout jsonIgnore
    @OneToMany(mappedBy = "destination")//bech ma ndhay3ch jpa fi assemi "nsaami nafss l'essm eli samit bih"
    private List<Voyage> voyages;
}
