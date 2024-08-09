package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(schema = "movie", name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staffId;
    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rentalId;
    @Column(name = "amount")
    private Double amount;
    @Column
    private Date paymentDate;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
