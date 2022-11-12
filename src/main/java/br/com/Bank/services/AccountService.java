package br.com.Bank.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Bank.model.Account;
import br.com.Bank.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public void createAccount(Account account) {
		
	}


}
