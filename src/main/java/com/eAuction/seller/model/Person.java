package com.eAuction.seller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Person")
@Data
@NoArgsConstructor
public class Person {
    @Id
    private String personId;
    @Column(name="fName")
    private String firstName;
    @Column(name="lName")
    private String lastName;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="pin")
    private String pin;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name="personType")
    private PersonTypeEnum personType;

}
