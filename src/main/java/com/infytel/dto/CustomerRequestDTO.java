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
public class CustomerRequestDTO {
    private Long phoneNumber;
    private String name;
    private Integer age;
    private Character gender;
    private String address;
    private Integer planId;

    public static Customer prepareCustomerEntity(CustomerRequestDTO customerRequestDTO)
    {
        Customer customer = new Customer();
        customer.setAge(customerRequestDTO.getAge());
        customer.setName(customerRequestDTO.getName());
        customer.setAddress(customerRequestDTO.getAddress());
        customer.setPlanId(customerRequestDTO.getPlanId());
        customer.setPhoneNumber(customerRequestDTO.getPhoneNumber());
        customer.setGender(customerRequestDTO.getGender());
        return customer;
    }
}