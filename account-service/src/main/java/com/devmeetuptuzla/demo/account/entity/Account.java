package com.devmeetuptuzla.demo.account.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double balance;
    @Column(nullable = false)
    private String currency;
    @Column(nullable = false)
    private String customerId;
}
