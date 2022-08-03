package com.reneg.productscommand.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column	(name="id")
    private Long id;

    @Column(name="description")
    private String description;

    @Column(name="fee")
    private Double fee;

    @Column(name="months")
    private Long months;


}

