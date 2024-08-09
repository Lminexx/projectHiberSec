package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "staff")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Short staffId;
    @Column(name = "first_name")
    private String  firstName;
    @Column(name = "last_name")
    private String  lastName;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address addressId;
    @Lob
    @Column(name = "picture")
    private byte[] picture;
    @Column
    private String email;
    @OneToOne
    @JoinColumn(name = "store_id")
    private Store storeId;
    @Column
    private Short active;
    @Column
    private String username;
    @Column
    private String password;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
