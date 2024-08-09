package org.example.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Enums.Rating;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "movie", name = "film")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short film_id;
    @Column(name="title")
    @Type(type="text")
    private String title;
    @Column(name = "description")
    @Type(type = "text")
    private String description;
    @Column(name = "release_year", columnDefinition = "Year")
    private Year releaseYear; //поменять тип
    @ManyToOne
    @JoinColumn(name="language_id")
    private Language languageId;
    @ManyToOne
    @JoinColumn(name="original_language_id")
    private Language originalLanguageId;
    @Column(name = "rental_duration")
    private Short rentalDuration;
    @Column(name="rental_rate")
    private Double rentalRate;
    @Column(name="length")
    private Short length;
    @Column(name = "replacement_cost")
    private Double replacementCost;
    @Column(name="rating", columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    private Rating rating;
    @ElementCollection
    @Column
    private Set<String> specialFeatures;
    @Column
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @ManyToMany
    @JoinTable(name="film_actor",
            joinColumns= @JoinColumn(name = "film_id",referencedColumnName = "film_id"),
            inverseJoinColumns= @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    private Set<Actor> actors;

    @ManyToMany
    @JoinTable(name = "film_category",
    joinColumns = @JoinColumn(name = "fild_id", referencedColumnName = "fild_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories;





}
