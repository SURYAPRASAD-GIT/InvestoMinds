
package com.java.Investominds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceResponse {

        private String first_name;
        private Double available_balance;

}

