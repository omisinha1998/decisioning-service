package com.omi.decisioning.service;

import com.omi.decisioning.dto.DecisionResponse;
import com.omi.decisioning.dto.LoanApplicationRequest;
import com.omi.decisioning.model.Decision;
import com.omi.decisioning.model.LoanApplication;
import com.omi.decisioning.repository.DecisionRepository;
import com.omi.decisioning.repository.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ValidationService validationService;
    private final EnrichmentService enrichmentService;
    private final DecisionEngine decisionEngine;
    private final LoanApplicationRepository appRepo;
    private final DecisionRepository decisionRepo;

    public DecisionResponse processApplication(
            LoanApplicationRequest req) {

        // 1. Validate
        validationService.validate(req);

        // 2. Map + Save
        LoanApplication app = new LoanApplication();
        app.setApplicantName(req.getApplicantName());
        app.setAnnualIncome(req.getAnnualIncome());
        app.setRequestedAmount(req.getRequestedAmount());
        app.setProductType(req.getProductType());
        app = appRepo.save(app);

        // 3. Enrich (bureau call)
        enrichmentService.enrich(app);
        appRepo.save(app);

        // 4. Decide
        Decision decision = decisionEngine.decide(app);
        decisionRepo.save(decision);

        // 5. Return response
        return new DecisionResponse(
                app.getId(),
                decision.getOutcome(),
                decision.getReason());
    }
}