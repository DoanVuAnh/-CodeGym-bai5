package com.example.quanlymu.services;

import com.example.quanlymu.dao.AccountDao;
import com.example.quanlymu.models.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountService implements IAccountService {
    static AccountDao accountDao = new AccountDao();

    public static Account checkLogin(String username, String password){
        return accountDao.checkLogin(username,password);
    }
    public static Map<Integer , Account> accountMap;
    static {
    accountMap.put(1,new Account(1,"Vu" , "hihi" , "ADMIN" , "VuAnh" ,15  , "345678" ,"hihi"));
}
    private Account account;

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accountMap.values());
    }

    @Override
    public void saveAccount(Account account) {
    accountMap.put(account.getId() , account);
    }

    @Override
    public Account findById(int id) {
        return accountMap.get(id);
    }

    @Override
    public void update(int id ,Account account) {
    accountMap.put(id , account );

    }

    @Override
    public void remove(int id) {
    accountMap.remove(id);

    }
}
