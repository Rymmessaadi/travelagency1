package com.ditraacademy.travelagency.core.chambre;



import com.ditraacademy.travelagency.core.categorie.Categorie;
import com.ditraacademy.travelagency.core.destination.Destination;
import com.ditraacademy.travelagency.core.type.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Categorie categorie;
}
