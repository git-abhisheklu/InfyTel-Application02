package com.infytel.repository;

import com.infytel.entity.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByName(String name);
    List<Customer> findByAge(Integer age);
    @Query(value = "select * from customer where customer.gender=?1", nativeQuery = true)
    List<Customer> findByGender(Character gender);
}
