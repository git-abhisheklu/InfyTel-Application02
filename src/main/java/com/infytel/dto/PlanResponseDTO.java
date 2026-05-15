package com.infytel.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PlanResponseDTO {
    private Integer planId;
    private String planName;
    private Integer nationalRate;
    private Integer localRate;
}
