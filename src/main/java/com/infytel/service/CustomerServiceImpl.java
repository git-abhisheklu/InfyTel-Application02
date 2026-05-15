package com.infytel.service;

import com.infytel.dao.CustomerDAO;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.CustomerResponseDTO;
import com.infytel.dto.UpdateCustomerDTO;
import com.infytel.entity.Customer;
import com.infytel.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("customerService")
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void insertCustomer(CustomerDTO customerDTO) {
        customerRepository.saveAndFlush(CustomerDTO.prepareCustomerEntity(customerDTO));
    }

    @Override
    public void removeCustomer(Long phoneNo) {
        customerRepository.deleteById(phoneNo);
    }

    @Override
    public CustomerResponseDTO getCustomer(Long phoneNo) {
        Optional<Customer> customer = customerRepository.findById(phoneNo);
        if(customer.isPresent()){
            Customer customer1 = customer.get();
            return Customer.prepareDTO(customer1);
        }
        return null;
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers(Integer page, Integer size, String sortBY, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc")? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page,size);
        Page<Customer> list = customerRepository.findAll(pageable);
        int totalCount = list.getSize();
        List<CustomerResponseDTO> dtoList = new ArrayList<>();
        for(Customer cust:list){
            dtoList.add(Customer.prepareDTO(cust));
        }
        return dtoList;
    }

    @Override
    public String updateCustomer(Long phoneNo, UpdateCustomerDTO updateCustomerDTO) {
        Optional<Customer> customer =customerRepository.findById(phoneNo);
        Customer customer1 = null;
        if(customer.isPresent()){
            customer1=customer.get();
            if(StringUtils.hasText(updateCustomerDTO.getName())){
                 customer1.setName(updateCustomerDTO.getName());
            }
            if(updateCustomerDTO.getAge()>0){
                customer1.setAge(updateCustomerDTO.getAge());
            }
            if (Character.isLetter(updateCustomerDTO.getGender())){
                customer1.setGender(updateCustomerDTO.getGender());
            }
            if(StringUtils.hasText(updateCustomerDTO.getAddress())){
                customer1.setAddress(updateCustomerDTO.getAddress());
            }
        }
        Customer savedCustomer = customerRepository.save(customer1);
        if (Objects.isNull(savedCustomer)){
            return "Customer with the given phone number is not updated...";
        }else{
         return "Customer has been updated successfully...";
        }
    }
}
