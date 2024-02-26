package com.lucasrech.olisaude.entities.healthIssue;

import com.lucasrech.olisaude.entities.customer.Customer;
import jakarta.persistence.*;

@Entity
public class HealthIssues {
    public Long id;

    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
    public Customer customer;

    @Enumerated(EnumType.STRING)
    public ProblemDegree degreeOfHealthProblem;
}
