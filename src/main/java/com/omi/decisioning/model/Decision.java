package com.omi.decisioning.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "decisions")
@Getter
@Setter
public class Decision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long applicationId;
    private String outcome;    // APPROVED / REJECTED / REFER
    private String reason;
    private LocalDateTime decidedAt;
}