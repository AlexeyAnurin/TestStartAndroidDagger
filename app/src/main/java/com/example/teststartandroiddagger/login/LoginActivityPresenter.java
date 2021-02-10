package com.example.teststartandroiddagger.login;

import com.example.teststartandroiddagger.account.AccountManager;
import com.example.teststartandroiddagger.datatype.Account;

public class LoginActivityPresenter {

    private LoginActivity activity;
    private AccountManager accountManager;

    public LoginActivityPresenter(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setActivity(LoginActivity activity) {
        this.activity = activity;
    }

    void login(String user, String password) {
        Account account = accountManager.login(user, password);
        activity.showMailForAccount(account);
    }

}
