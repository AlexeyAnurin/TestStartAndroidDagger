package com.example.teststartandroiddagger.mail;

import java.util.List;

import com.example.teststartandroiddagger.api.ApiService;
import com.example.teststartandroiddagger.datatype.Account;
import com.example.teststartandroiddagger.datatype.Folder;
import com.example.teststartandroiddagger.datatype.Letter;

public class MailManager {

    private Account account;
    private ApiService apiService;

    public MailManager(Account account, ApiService apiService) {
        this.account = account;
        this.apiService = apiService;
    }

    public List<Folder> getFolders() {
        return apiService.getFolders(account);
    }

    public List<Letter> getLetters(Folder folder) {
        return apiService.getLetters(folder);
    }
}
