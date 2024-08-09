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
public class Address {
    @Id
    private Integer addressId;
    @Column
    private String address;
    @Column
    private String address2;
    @Column
    private String district;
    @Column
    private Integer cityId;
    @Column
    private String postalCode;
    @Column
    private String phone;
    @Column
    private Date lastUpdate;

}
