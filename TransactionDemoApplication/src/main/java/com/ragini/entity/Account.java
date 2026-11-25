package com.ragini.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name ;
    private BigDecimal balance ;

    public void debitAccount(BigDecimal amount){

        if(amount == null || amount.signum() <= 0){

            throw new IllegalArgumentException("Amount must be positive !!!");
        }
        if(balance.compareTo(amount) <= 0){

            throw new RuntimeException("Insufficient balance !!!");
        }

        balance = balance.subtract(amount) ;
    }

    public void creditAccount(BigDecimal amount){

        if(amount == null || amount.signum() <= 0){

            throw new IllegalArgumentException("Amount must be positive !!!");
        }

        balance = balance.add(amount) ;
    }
}

