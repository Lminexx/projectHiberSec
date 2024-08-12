package org.example.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Conventers.YearConventer;
import org.example.Enums.Feature;
import org.example.Enums.Rating;
import org.example.Conventers.RatingConventor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

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
    @Column(name = "title", columnDefinition = "LONGTEXT")
    private String title;
    @Column(name = "description")
    @Type(type = "text")
    private String description;
    @Column(name = "release_year", columnDefinition = "Year")
    @Convert(converter = YearConventer.class)
    private Year releaseYear;
    @ManyToOne
    @JoinColumn(name="language_id")
    private Language languageId;
    @ManyToOne
    @JoinColumn(name="original_language_id")
    private Language originalLanguageId;
    @Column(name = "rental_duration")
    private Byte rentalDuration;
    @Column(name = "rental_rate", precision = 5, scale = 2)
    private BigDecimal rentalRate;
    @Column(name="length")
    private Short length;
    @Column(name = "replacement_cost", precision = 5, scale = 2)
    private BigDecimal replacementCost;
    @Column(name="rating", columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    @Convert(converter = RatingConventor.class)
    private Rating rating;
    @Column(name = "special_features", columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;
    @ManyToMany
    @JoinTable(name="film_actor",
            joinColumns= @JoinColumn(name = "film_id",referencedColumnName = "film_id"),
            inverseJoinColumns= @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    private Set<Actor> actors;
    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;


    public Set<Feature> getSpecialFeatures() {
        if (isNull(specialFeatures) || specialFeatures.isEmpty()) {
            return null;
        }
        Set<Feature> result = new HashSet<>();
        String[] features = specialFeatures.split(" ");
        for (String feature : features) {
            result.add(Feature.fromValue(feature));
        }
        result.remove(null);
        return result;
    }
    public void setSpecialFeatures(Set<Feature> specialFeatures) {
        if(isNull(specialFeatures)){
            specialFeatures = null;
        }else{
            specialFeatures.stream().map(Feature::getValue).collect(Collectors.joining(","));
        }
    }
}
