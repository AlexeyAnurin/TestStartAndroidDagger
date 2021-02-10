package com.example.teststartandroiddagger;

import javax.inject.Singleton;

import dagger.Component;
import com.example.teststartandroiddagger.api.ApiModule;
import com.example.teststartandroiddagger.login.LoginActivityComponent;
import com.example.teststartandroiddagger.mail.MailComponent;
import com.example.teststartandroiddagger.mail.MailModule;

// AppComponent - создается на все время работы приложения. Соответственно, объекты, которые
// он умеет создавать и которые имеют тот же scope, что и у него, будут синглтонами на протяжении
// жизни этого компонента. В данном примере - это класс по работе с сетью ApiService.
// MailComponent - создается на время работы с почтой. Его синглтон - это класс для работы с
// почтой MailManager.
// И по одному компоненту для каждого Activity. Их синглтоны - это презентеры.

//  глобальный компонент
@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {

    //  отдельный компонент.
    LoginActivityComponent createLoginComponent();

    //  в рамках MailComponent находятся Folder & Letter Components
    MailComponent createMailComponent(MailModule mailModule);
}
