package com.example.teststartandroiddagger.login;

import dagger.Subcomponent;
import com.example.teststartandroiddagger.ActivityScope;

@ActivityScope
@Subcomponent(modules = LoginActivityModule.class)
public interface LoginActivityComponent {

    void injectLoginActivity(LoginActivity activity);

}
