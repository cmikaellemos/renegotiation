package com.reneg.debtscommand.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "debt")
public class Debt {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column	(name="id")
    private Long id;

    @Column(name="account")
    private String account;

    @Column(name="value")
    private Double value;

    @Column(name="due_date")
    private LocalDate dueDate;

    @Column(name="status")
    private String status;

}

