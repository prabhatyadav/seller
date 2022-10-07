package com.eAuction.seller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
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

    @Column(name="bidStartDate")
    private LocalDateTime bidStartDate;

    @Column(name="createdDate")
    private LocalDateTime createdDate;

    @ManyToOne
    private Person seller;

    @Column(name="isDeleted")
    private  Boolean isDeleted;

}
