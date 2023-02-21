package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerService;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer dao
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {

        //get customers from the service
        List<Customer> customers = customerService.getCustomers();

        System.out.println(customers);
        // add the customers to Model
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
