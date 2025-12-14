package com.project.vmeal.Service;

import com.project.vmeal.Entity.Customer;
import com.project.vmeal.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create/Add new Customer
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get all Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get Customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Update Customer
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhone(customerDetails.getPhone());
        customer.setAddress(customerDetails.getAddress());

        return customerRepository.save(customer);
    }

    // Delete Customer
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
