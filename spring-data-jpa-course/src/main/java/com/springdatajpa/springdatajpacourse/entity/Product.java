package com.springdatajpa.springdatajpacourse.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
//need to get the getter we need to get the geters from lombok
//@setter to get all the setters
//@Noarugumentconstructor non parameterized constructor
//All Arugumentconstructot for all parameterized constructor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="Product",
schema ="ecommerce",
        uniqueConstraints ={
       @UniqueConstraint(
               name="sku_unique",
               columnNames = "stock_keeping_unit"
  )
        }
)

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "product_generator")
    @SequenceGenerator(
            name="Product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 2
    )
    //Autoincement the column identity
    private Long id;
    @Column(name="stock_keeping_unit",nullable=false)
    private String Sku;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


}
