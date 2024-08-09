package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(schema = "movie", name = "language")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Language {
    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer languageId;
    @Column
    private String name;
    @Column(name="last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
