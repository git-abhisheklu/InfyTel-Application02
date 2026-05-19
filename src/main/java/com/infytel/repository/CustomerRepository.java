package com.infytel.repository;

import com.infytel.entity.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByName(String name);
    List<Customer> findByAge(Integer age);
}
