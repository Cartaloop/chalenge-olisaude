package com.lucasrech.olisaude.services;


import com.lucasrech.olisaude.dtos.RequestResponse;
import com.lucasrech.olisaude.entities.customer.Customer;
import com.lucasrech.olisaude.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);


    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    @Async
    public CompletableFuture<Customer> createNewCustomer(RequestResponse newCustomerDto) throws InterruptedException {
        logger.info("Creating user" + newCustomerDto);

        try {
            Customer newCustomer = new Customer(
                    newCustomerDto.name(),
                    newCustomerDto.dateOfBirth(),
                    newCustomerDto.genre(),
                    newCustomerDto.healthIssues());

            return CompletableFuture.completedFuture(repository.save(newCustomer));
        } catch (Exception e) {
            logger.error("Error creating user", e);
            throw e;
        }
    }

}
