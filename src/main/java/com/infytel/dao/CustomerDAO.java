package com.infytel.dao;

import com.infytel.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public void insert(Customer customer);

    public int remove(Long phoneNo);

    public List<Customer> getAll();

    public int update(Long phoneNo, String address, String name);
}
