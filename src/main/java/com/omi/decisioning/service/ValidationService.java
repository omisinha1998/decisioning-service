package com.omi.decisioning.service;

import com.omi.decisioning.dto.LoanApplicationRequest;
import com.omi.decisioning.exception.ValidationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValidationService {

    public void validate(LoanApplicationRequest req) {
        if (!List.of("LOAN", "CREDIT_CARD")
                .contains(req.getProductType())) {
            throw new ValidationException(
                    "Invalid productType: " + req.getProductType());
        }
        if (req.getRequestedAmount() > 5_000_000) {
            throw new ValidationException(
                    "Amount exceeds max limit (50L)");
        }
    }
}