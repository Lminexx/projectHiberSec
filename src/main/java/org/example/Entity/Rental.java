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
public class Rental {
    @Id
    private Integer rantalId;
    @Column
    private Date rantalDate;
    @Column
    private Integer inventoryId;
    @Column
    private Integer customerId;
    @Column
    private Date returnDate;
    @Column
    private Integer staffId;
    @Column
    private Date lastUpdate;
}
