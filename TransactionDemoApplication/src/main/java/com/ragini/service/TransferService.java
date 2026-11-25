package com.ragini.service;

import com.ragini.entity.Account;
import com.ragini.entity.TransferRecord;
import com.ragini.repository.AccountRepository;
import com.ragini.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {

    private AccountRepository accountRepository ;
    private TransferRepository transferRepository ;

    public TransferService(AccountRepository accountRepository , TransferRepository transferRepository){

       this.accountRepository = accountRepository ;
       this.transferRepository = transferRepository ;
    }

    @Transactional
    public void transfer(Integer fromAccountId,
                         Integer toAccountId,
                         BigDecimal amount){

        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account toAccount =accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        fromAccount.debitAccount(amount);
        toAccount.creditAccount(amount);

        transferRepository.save(new TransferRecord(
                fromAccountId ,
                toAccountId ,
                amount ,
                LocalDate.now()
        ));

    }
}
