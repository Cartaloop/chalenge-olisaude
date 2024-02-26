package com.lucasrech.olisaude.entities.customer;

import com.lucasrech.olisaude.entities.healthIssue.HealthIssues;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    public Long id;

    @Column(name = "customer_name", length = 70, nullable = false)
    public String name;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    public Genre genre;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    public List<HealthIssues> healthIssues = new ArrayList<>();
    public Date creationDate;
    public Date updateDate;

}
