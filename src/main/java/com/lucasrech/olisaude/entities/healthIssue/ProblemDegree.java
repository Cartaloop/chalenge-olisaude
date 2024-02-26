package com.lucasrech.olisaude.entities.healthIssue;

import lombok.Getter;

@Getter
public enum ProblemDegree {
    GRAU_1("Grau 1"),
    GRAU_2("Grau 2");

    private final String descricao;

    ProblemDegree(String descricao) {
        this.descricao = descricao;
    }

}

