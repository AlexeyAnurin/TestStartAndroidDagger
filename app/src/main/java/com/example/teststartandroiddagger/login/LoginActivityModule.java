package com.example.teststartandroiddagger.login;

import dagger.Module;
import dagger.Provides;
import com.example.teststartandroiddagger.ActivityScope;
import com.example.teststartandroiddagger.account.AccountManager;
import com.example.teststartandroiddagger.api.ApiService;

@Module
public class LoginActivityModule {

    @ActivityScope
    @Provides
    AccountManager provideAccountManager(ApiService apiService) {
        return new AccountManager(apiService);
    }

    @ActivityScope
    @Provides
    LoginActivityPresenter provideLoginActivityPresenter(AccountManager accountManager) {
        return new LoginActivityPresenter(accountManager);
    }

}
