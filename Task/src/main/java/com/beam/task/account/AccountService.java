package com.beam.task.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    public void signup(Account account) {
        if (accountRepository.findByName(account.getName()) != null)
            throw new RuntimeException("already have this name");
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setId(UUID.randomUUID().toString());
        accountRepository.save(account);
    }

    public Account login(Account account) {
        Account acc = accountRepository.findByName(account.getName());

        if (acc == null)
            return null;

        if (passwordEncoder.matches(account.getPassword(), acc.getPassword()))
            return acc;

        return null;

    }
    public List<Account> getAllUser() {

        return accountRepository.findAll();
    }


}
