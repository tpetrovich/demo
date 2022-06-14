package com.example.demo.service.implementation;

import com.example.demo.exception.RequestNotFoundException;
import com.example.demo.exception.RequestSystemException;
import com.example.demo.exception.RequestValidationException;
import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    public CustomerServiceImpl(CustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public Customer add(Customer customer) {
        dataValidation(customer);
        try {
            return repo.save(customer);
        }catch (DataAccessException e){
            throw new RequestSystemException("Ocurrió un error en la base de datos");
        }
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> customerOptional = repo.findById(customer.getId());
        if(customerOptional.isPresent())
            return repo.save(customer);
        else
            throw new RequestNotFoundException("Cliente no encontrado");
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customerOptional = repo.findById(id);
        if(customerOptional.isPresent())
            repo.delete(customerOptional.get());
        else
            throw new RequestNotFoundException("Cliente no encontrado");
    }

    @Override
    public Customer detail(Long id) {
        Optional<Customer> customerOptional = repo.findById(id);
        if(customerOptional.isPresent())
            return customerOptional.get();
        else
            throw new RequestNotFoundException("Cliente no encontrado");
    }

    @Override
    public List<Customer> list() {
        return repo.findAll();
    }

    private void dataValidation(Customer customer){
        if(customer.getName()==null || customer.getName().isEmpty()){
            throw new RequestValidationException("Debe ingresar un nombre para el cliente");
        }
        if(customer.getMail()==null || customer.getMail().isEmpty()){
            throw new RequestValidationException("Debe ingresar un mail para el cliente");
        }
    }
}
