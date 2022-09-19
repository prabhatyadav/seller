package com.eAuction.seller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="shortDescription")
    private String shortDescription;

    @Column(name="detailedDescription")
    private String detailedDescription;

    @ManyToOne
    private ProductCategory category;

    @Column(name="startingPrice")
    private double startingPrice;

    @Column(name="bidEndDate")
    private LocalDateTime bidEndDate;

    @ManyToOne
    @Column(name="seller")
    private Person seller;

}
