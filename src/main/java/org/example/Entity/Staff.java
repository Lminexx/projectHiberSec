package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Staff {
    @Id
    private Integer staffId;
    @Column
    private String  firstName;
    @Column
    private String  lastName;
    @Column
    private Integer addressId;
    @Lob
    @Column
    private byte[] picture;
    @Column
    private String email;
    @Column
    private Integer storeId;
    @Column
    private Integer active;
    @Column
    private String username;
    @Column
    private String password;

}
