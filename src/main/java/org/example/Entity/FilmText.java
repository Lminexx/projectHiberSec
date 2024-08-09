package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "movie", name = "film_text")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilmText {
    @Id
    @Column(name = "film_id")
    private Short filmId;
    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Column
    private String title;
    @Column
    private String description;
}
