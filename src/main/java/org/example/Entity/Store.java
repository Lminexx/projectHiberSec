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

public class Store {
    @Id
    private Integer storeId;
    @Column
    private Integer managerStaffId;
    @Column
    private Integer addressId;
    @Column
    private Date lastUpdate;
}
