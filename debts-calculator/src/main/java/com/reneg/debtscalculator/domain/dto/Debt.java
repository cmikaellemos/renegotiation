package com.reneg.debtscalculator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Debt {

    private Long id;
    private String account;
    private Double value;
    private String dueDate;
    private String status;

}

