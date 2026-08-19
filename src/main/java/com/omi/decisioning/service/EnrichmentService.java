package com.omi.decisioning.service;

import com.omi.decisioning.client.BureauClient;
import com.omi.decisioning.model.LoanApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrichmentService {

    private final BureauClient bureauClient;

    public void enrich(LoanApplication app) {
        Integer score = bureauClient
                .fetchCreditScore(app.getApplicantName());
        app.setCreditScore(score);
    }
}