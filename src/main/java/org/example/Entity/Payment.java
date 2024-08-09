package org.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    private Integer paymentId;
    @Column
    private Integer customerId;
    @Column
    private Integer staffId;
    @Column
    private Integer rentalId;
    @Column
    private Double amount;
    @Column
    private Date paymentDate;
    @Column
    private Date lastUpdate;
}
