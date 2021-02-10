package com.example.teststartandroiddagger.mail;

import dagger.Subcomponent;
import com.example.teststartandroiddagger.folders.FolderListActivityComponent;
import com.example.teststartandroiddagger.letters.LetterListActivityComponent;
import com.example.teststartandroiddagger.letters.LetterListActivityModule;

@MailScope
@Subcomponent(modules = MailModule.class)
public interface MailComponent {

    FolderListActivityComponent createFoldersListActivityComponent();

    LetterListActivityComponent createLetterListActivityComponent(LetterListActivityModule letterListActivityModule);

}
