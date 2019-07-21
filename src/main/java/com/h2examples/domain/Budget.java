package com.h2examples.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budget_generator")
    @SequenceGenerator(name = "budget_generator", sequenceName = "budget_seq")
    private Long id;
    private String name;

    @OneToMany(
            targetEntity = Account.class,
            mappedBy = "budget",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER
    )
    @JsonIgnore
    private List<Account> accounts = new ArrayList<>();

    public Budget(String name) {
        this.name = name;
    }
}
