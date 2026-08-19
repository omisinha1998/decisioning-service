package com.omi.decisioning.service;

import com.omi.decisioning.model.Decision;
import com.omi.decisioning.model.LoanApplication;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class DecisionEngine {

    public Decision decide(LoanApplication app) {
        Decision d = new Decision();
        d.setApplicationId(app.getId());

        double dti = (double) app.getRequestedAmount()
                / app.getAnnualIncome();

        if (app.getCreditScore() == null) {
            d.setOutcome("REFER");
            d.setReason("Credit score unavailable");
        } else if (app.getCreditScore() >= 750 && dti < 0.4) {
            d.setOutcome("APPROVED");
            d.setReason("High credit score, healthy DTI");
        } else if (app.getCreditScore() < 600 || dti > 0.6) {
            d.setOutcome("REJECTED");
            d.setReason("Low credit score or high DTI");
        } else {
            d.setOutcome("REFER");
            d.setReason("Borderline case, manual review needed");
        }
        d.setDecidedAt(LocalDateTime.now());
        return d;
    }
}