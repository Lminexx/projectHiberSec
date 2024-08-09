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
@Table(schema = "movie", name = "rental")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer rentalId;
    @Column(name = "rental_date")
    private Date rantalDate;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventoryId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;
    @Column(name = "return_date")
    private Date returnDate;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staffId;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
