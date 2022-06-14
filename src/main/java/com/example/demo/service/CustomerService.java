package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer add(Customer customer);

    Customer update(Customer customer);

    void delete(Long id);

    Customer detail(Long id);

    List<Customer> list();
}
