package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.CustomerService;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements com.luv2code.springdemo.service.CustomerService {

    // need to inject customer dao
    private final CustomerService customerDAO;

    public CustomerServiceImpl(CustomerService customerDAO) {
        this.customerDAO = customerDAO;
    }


    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}
