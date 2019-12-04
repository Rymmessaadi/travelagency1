package com.ditraacademy.travelagency.core.type;

import com.ditraacademy.travelagency.core.chambre.Chambre;
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
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "chambre")
    private List<Chambre> chambres;

}
