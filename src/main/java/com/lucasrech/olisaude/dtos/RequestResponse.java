package com.lucasrech.olisaude.dtos;


import com.lucasrech.olisaude.entities.customer.Genre;
import com.lucasrech.olisaude.entities.healthIssue.HealthIssues;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public record RequestResponse(String name, Date dateOfBirth, Genre genre, List<HealthIssues> healthIssues) {
}
