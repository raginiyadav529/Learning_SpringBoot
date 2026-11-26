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
public class PaymentAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private BigDecimal amount ;
    private Integer orderId;
    private Boolean success ;


    public PaymentAudit(BigDecimal amount, Integer orderId, Boolean success) {
        this.amount = amount;
        this.orderId = orderId;
        this.success = success;
    }
}
