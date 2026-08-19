package com.omi.decisioning.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class BureauClient {

    @CircuitBreaker(name = "bureau",
            fallbackMethod = "fallbackScore")
    public Integer fetchCreditScore(String applicantName) {
        // 30% chance fail — simulate flaky bureau API
        if (Math.random() < 0.3) {
            throw new RuntimeException("Bureau API down!");
        }
        return 600 + new Random().nextInt(250); // 600-850
    }

    public Integer fallbackScore(String applicantName,
                                 Throwable t) {
        return null; // null → DecisionEngine REFER karega
    }
}