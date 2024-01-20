package com.java.Investominds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentplansResponseDTO {

    private String firstName;
    private String plan_names;
    private String term_period;
    private String plan_description;
    private Float rate_of_return;
    private Double min_amount;
}
