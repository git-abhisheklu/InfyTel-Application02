package com.infytel.controller;

import com.infytel.dto.CustomerDTO;
import com.infytel.dto.CustomerResponseDTO;
import com.infytel.dto.UpdateCustomerDTO;
import com.infytel.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerServiceImpl customerServiceImpl;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> insertCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            customerServiceImpl.insertCustomer(customerDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Record has been added successfully...", HttpStatus.OK);
    }

    @GetMapping(value = "/{phoneNumber}", produces = "application/json")
    public ResponseEntity<?> fetchCustomer(@PathVariable Long phoneNumber) {
        CustomerResponseDTO cRDTO = customerServiceImpl.getCustomer(phoneNumber);
        if (Objects.isNull(cRDTO)) {
            return new ResponseEntity<>("No record found for the given phone number...", HttpStatus.OK);
        }
        return new ResponseEntity<>(cRDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getByName", produces = "application/json")
    public ResponseEntity<?> fetchCustomerByName(@RequestParam String name) {
        CustomerResponseDTO cRDTO = customerServiceImpl.getCustomerByName(name);
        if (Objects.isNull(cRDTO)) {
            return new ResponseEntity<>("No record found for the given name...", HttpStatus.OK);
        }
        return new ResponseEntity<>(cRDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getByGender", produces = "application/json")
    public ResponseEntity<?> fetchCustomerByGender(@RequestParam String gender) {
        List<CustomerResponseDTO> cRDTO = customerServiceImpl.getCustomerByGender(gender.charAt(0));
        if (Objects.isNull(cRDTO)) {
            return new ResponseEntity<>("No record found for the given name...", HttpStatus.OK);
        }
        return new ResponseEntity<>(cRDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getByAge", produces = "application/json")
    public ResponseEntity<?> fetchCustomerByAge(@RequestParam Integer age ) {
        List<CustomerResponseDTO> cRDTO = customerServiceImpl.getCustomerByAge(age);
        if (Objects.isNull(cRDTO)) {
            return new ResponseEntity<>("No record found for the given name...", HttpStatus.OK);
        }
        return new ResponseEntity<>(cRDTO, HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public List<CustomerResponseDTO> fetchCustomers(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "1") Integer size, @RequestParam(defaultValue = "phoneNumber") String sortBy, @RequestParam(defaultValue = "desc") String sortOrder) {
        return customerServiceImpl.getAllCustomers(page, size, sortBy, sortOrder);
    }

    @PatchMapping(value = "/{phoneNumber}")
    public String updateCustomer(@PathVariable Long phoneNumber, @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        return customerServiceImpl.updateCustomer(phoneNumber, updateCustomerDTO);
    }

    @DeleteMapping("/{phoneNumber}")
    public String deleteCustomer(@PathVariable Long phoneNumber) {
        customerServiceImpl.removeCustomer(phoneNumber);
        return "Customer has been removed successfully... ";
    }
}
