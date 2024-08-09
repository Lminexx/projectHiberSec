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
@Table(schema = "movie", name = "store")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Byte storeId;
    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    private Staff managerStaffId;
    @OneToOne
    @JoinColumn(name="address_id")
    private Address addressId;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
