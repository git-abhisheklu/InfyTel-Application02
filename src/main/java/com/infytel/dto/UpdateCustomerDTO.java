package com.infytel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerDTO {
    private String Name;
    private Integer age;
    private Character gender;
    private String address;
}
