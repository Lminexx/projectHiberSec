package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(schema = "movie", name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Short addressId;
    @Column(name = "address")
    private String address;
    @Column(name = "address2")
    private String address2;
    @Column
    private String district;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City cityId;
    @Column(name = "postal_code")
    private String postalCode;
    @Column
    private String phone;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
