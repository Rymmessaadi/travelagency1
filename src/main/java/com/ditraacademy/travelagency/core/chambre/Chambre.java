package com.ditraacademy.travelagency.core.chambre;



import com.ditraacademy.travelagency.core.destination.Destination;
import com.ditraacademy.travelagency.core.type.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @ManyToOne
    private Type type;
    private Chambre chambre;

}
