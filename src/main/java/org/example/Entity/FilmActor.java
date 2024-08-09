package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(schema = "movie", name = "film_actor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmActor {
    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short actorId;
    @Column(name = "film_id")
    private Short filmId;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
