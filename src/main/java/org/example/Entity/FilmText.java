package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilmText {
    @Id
    @OneToOne
    private Integer filmId;
    @Column
    private String title;
    @Column
    private String description;
}
