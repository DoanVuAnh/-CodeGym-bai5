package com.example.quanlymu.services;

import com.example.quanlymu.models.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    void saveAccount(Account account);
    Account findById(int id);
    void update(int id ,Account account);

    void remove(int id);
}
