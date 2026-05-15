package com.infytel.dto;

import com.infytel.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private Long phoneNumber;
    private String name;
    private Integer age;
    private Character gender;
    private Integer planId;
    private String address;
}