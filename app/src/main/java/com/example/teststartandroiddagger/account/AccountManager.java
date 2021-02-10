package com.example.teststartandroiddagger.account;

import com.example.teststartandroiddagger.api.ApiService;
import com.example.teststartandroiddagger.datatype.Account;

public class AccountManager {

    private ApiService apiService;

    public AccountManager(ApiService apiService) {
        this.apiService = apiService;
    }

    public Account login(String user, String password) {
        return apiService.login(user, password);
    }

}
