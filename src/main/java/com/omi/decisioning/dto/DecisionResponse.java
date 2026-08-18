package com.omi.decisioning.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DecisionResponse {
    private Long applicationId;
    private String outcome;
    private String reason;
}