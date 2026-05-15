package com.infytel.dto;

import com.infytel.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long phoneNumber;
    private String name;
    private Integer age;
    private Character gender;
    private String address;
    private Integer planId;

    public static Customer prepareCustomerEntity(CustomerDTO customerDTO)
    {
        Customer customer = new Customer();
        customer.setAge(customerDTO.getAge());
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPlanId(customerDTO.getPlanId());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setGender(customerDTO.getGender());
        return customer;
    }
}
