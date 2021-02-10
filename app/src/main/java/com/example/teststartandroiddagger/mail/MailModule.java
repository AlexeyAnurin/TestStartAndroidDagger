package com.example.teststartandroiddagger.mail;

import android.util.Log;

import dagger.Module;
import dagger.Provides;
import com.example.teststartandroiddagger.api.ApiService;
import com.example.teststartandroiddagger.datatype.Account;

@Module
public class MailModule {

    private Account account;

    public MailModule(Account account) {
        this.account = account;
    }

    @Provides
    public Account provideAccount() {
        return account;
    }

    @Provides
    @MailScope
    MailManager provideMailManager(Account account, ApiService apiService) {
        return new MailManager(account, apiService);
    }

}
