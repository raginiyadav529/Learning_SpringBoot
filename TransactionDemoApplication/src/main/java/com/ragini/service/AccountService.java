package com.ragini.service;

import com.ragini.entity.Account;
import com.ragini.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    AccountRepository accountRepository ;

    public AccountService(AccountRepository accountRepository){

        this.accountRepository = accountRepository ;
    }

    public void createAccount(Account account){

        accountRepository.save(account);
    }

}
