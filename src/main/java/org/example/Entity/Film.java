package org.example.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Enums.Rating;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Film {
    @Id
    private Integer film_id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String releaseDate; //поменять тип
    @Column
    private Integer languageId;
    @Column
    private Integer originalLanguageId;
    @Column
    private Integer rentalDuration;
    @Column
    private Integer rentalRate;
    @Column
    private Integer length;
    @Column
    private Double replacementCost;
    @Column
    private Rating rating;
    @ElementCollection
    @Column
    private Set<String> specialFeatures;
    @Column
    private Date lastUpdate;



}
