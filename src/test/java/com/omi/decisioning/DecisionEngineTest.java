package com.omi.decisioning;

import com.omi.decisioning.model.Decision;
import com.omi.decisioning.model.LoanApplication;
import com.omi.decisioning.service.DecisionEngine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DecisionEngineTest {

    private final DecisionEngine engine = new DecisionEngine();

    @Test
    void highScore_lowDti_shouldApprove() {
        LoanApplication app = new LoanApplication();
        app.setCreditScore(780);
        app.setAnnualIncome(1_000_000.0);
        app.setRequestedAmount(200_000);

        Decision d = engine.decide(app);
        assertEquals("APPROVED", d.getOutcome());
    }

    @Test
    void lowScore_shouldReject() {
        LoanApplication app = new LoanApplication();
        app.setCreditScore(550);
        app.setAnnualIncome(1_000_000.0);
        app.setRequestedAmount(200_000);

        Decision d = engine.decide(app);
        assertEquals("REJECTED", d.getOutcome());
    }

    @Test
    void nullScore_shouldRefer() {
        LoanApplication app = new LoanApplication();
        app.setCreditScore(null);
        app.setAnnualIncome(1_000_000.0);
        app.setRequestedAmount(200_000);

        Decision d = engine.decide(app);
        assertEquals("REFER", d.getOutcome());
    }

    @Test
    void highDti_shouldReject() {
        LoanApplication app = new LoanApplication();
        app.setCreditScore(700);
        app.setAnnualIncome(500_000.0);
        app.setRequestedAmount(400_000);

        Decision d = engine.decide(app);
        assertEquals("REJECTED", d.getOutcome());
    }
}