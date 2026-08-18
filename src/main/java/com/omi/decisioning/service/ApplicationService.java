package com.omi.decisioning.service;

import com.omi.decisioning.dto.DecisionResponse;
import com.omi.decisioning.dto.LoanApplicationRequest;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    public DecisionResponse processApplication(
            LoanApplicationRequest req) {
        // agle step me implement karenge
        return new DecisionResponse(1L, "PENDING", "In progress");
    }
}