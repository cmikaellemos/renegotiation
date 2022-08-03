package com.reneg.debtscalculator.domain.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Simulation {

    private Long months;
    private Double value;
    private Double finalValue;
    private Double valueMonth;
    private Double fee;

}

