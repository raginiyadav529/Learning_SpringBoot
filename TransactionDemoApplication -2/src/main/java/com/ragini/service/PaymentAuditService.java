package com.ragini.service;

import com.ragini.entity.Order;
import com.ragini.entity.PaymentAudit;
import com.ragini.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {

   private PaymentAuditRepository paymentAuditRepository ;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository){

        this.paymentAuditRepository = paymentAuditRepository ;
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ
    )
    public void audit(Order order) {

       PaymentAudit paymentAudit = new PaymentAudit (
               order.getAmount() ,
               order.getId(),
               true
       );

       paymentAuditRepository.save(paymentAudit) ;
    }
}


// propagation = Propagation.REQUIRED, Propagation.REQUIRES_NEW ,
// Propagation.SUPPORT, Propagation.MANDATORY
/**
 *
 *  ( propagation = Propagation.REQUIRES_NEW )
 *  Both transactions will be separate and if any exception occurs in placeOrder () method -
 *  then only placeOrder () method will be rolled back ,,, audit ()method has its own transaction-
 *  so it will commit in database and there will be no rolled back .
 *
 *  propagation = Propagation.REQUIRES_NEW--> we should only be used if we know that the inner and
 *  outer method are independent of each other , and both can run in their own transactions .

 * ***/