package com.eAuction.seller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "person",
        uniqueConstraints = @UniqueConstraint(columnNames={"email","phone","person_type"}))
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "pin")
    private String pin;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email" ,unique = true)
    private String email;
    @Column(name = "personType")
    private PersonTypeEnum personType;

}
