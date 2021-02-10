package com.example.teststartandroiddagger.login;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import com.example.teststartandroiddagger.App;
import com.example.teststartandroiddagger.R;
import com.example.teststartandroiddagger.datatype.Account;
import com.example.teststartandroiddagger.folders.FolderListActivity;

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginActivityPresenter presenter;

    EditText userEditText;
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginActivityComponent loginActivityComponent = App.getInstance().getAppComponent().createLoginComponent();

        loginActivityComponent.injectLoginActivity(this);

        userEditText = (EditText)findViewById(R.id.user);
        passwordEditText = (EditText)findViewById(R.id.password);

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(userEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });
    }

    void showMailForAccount(Account account) {
        App.getInstance().createMailComponent(account);
        startActivity(new Intent(this, FolderListActivity.class));
    }

    @Inject
    void setActivity() {
        presenter.setActivity(this);
    }
}
