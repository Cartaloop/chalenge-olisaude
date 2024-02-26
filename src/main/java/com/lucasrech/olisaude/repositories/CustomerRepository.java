package com.lucasrech.olisaude.repositories;

import com.lucasrech.olisaude.entities.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
