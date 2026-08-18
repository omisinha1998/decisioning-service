package com.omi.decisioning.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanApplicationRequest {

    @NotBlank(message = "Name required")
    private String applicantName;

    @NotNull(message = "Income required")
    @Positive(message = "Income must be positive")
    private Double annualIncome;

    @NotNull(message = "Amount required")
    @Positive(message = "Amount must be positive")
    private Integer requestedAmount;

    @NotBlank(message = "Product type required")
    private String productType;
}