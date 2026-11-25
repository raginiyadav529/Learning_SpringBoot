package com.ragini.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class TransferRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Integer fromAccountId ;
    private Integer toAccountId ;
    private BigDecimal amount ;
    private LocalDate transferAt ;


    public TransferRecord(Integer fromAccountId, Integer toAccountId, BigDecimal amount, LocalDate transferAt) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.transferAt = transferAt;
    }
}
