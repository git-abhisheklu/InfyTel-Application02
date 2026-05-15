package com.infytel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CallDetailsDTO {
    long calledBy;
    long calledTo;
    LocalDate calledOn;
    int duration;
}
