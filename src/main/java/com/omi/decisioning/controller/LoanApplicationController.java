package com.omi.decisioning.controller;

import com.omi.decisioning.dto.DecisionResponse;
import com.omi.decisioning.dto.LoanApplicationRequest;
import com.omi.decisioning.service.ApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/applications")
@RequiredArgsConstructor          // ← YE HONA CHAHIYE
public class LoanApplicationController {

    private final ApplicationService applicationService;  // ← final hona chahiye

    @PostMapping
    public ResponseEntity<DecisionResponse> apply(
            @Valid @RequestBody LoanApplicationRequest request) {
        return ResponseEntity.ok(
                applicationService.processApplication(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id) {
        return ResponseEntity.ok("OK");
    }
}