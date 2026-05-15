package com.infytel.service;

import com.infytel.dto.CustomerDTO;
import com.infytel.dto.CustomerResponseDTO;
import com.infytel.dto.UpdateCustomerDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CustomerService {
    public void insertCustomer(CustomerDTO customerDTO);

    public CustomerResponseDTO getCustomer(Long phoneNo);

    public void removeCustomer(Long phoneNo);

    public List<CustomerResponseDTO> getAllCustomers(Integer page, Integer size, String sortBy, String sortOrder);

    public String updateCustomer(Long phoneNo, UpdateCustomerDTO updateCustomerDTO);
}
