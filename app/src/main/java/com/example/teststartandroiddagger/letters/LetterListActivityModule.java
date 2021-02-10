package com.example.teststartandroiddagger.letters;

import dagger.Module;
import dagger.Provides;
import com.example.teststartandroiddagger.ActivityScope;
import com.example.teststartandroiddagger.datatype.Folder;
import com.example.teststartandroiddagger.mail.MailManager;

@Module
public class LetterListActivityModule {

    private Folder folder;

    public LetterListActivityModule(Folder folder) {
        this.folder = folder;
    }

    @ActivityScope
    @Provides
    public Folder provideFolder() {
        return folder;
    }

    @ActivityScope
    @Provides
    public LetterListActivityPresenter provideLettersListActivityPresenter(Folder folder, MailManager mailManager) {
        return new LetterListActivityPresenter(folder, mailManager);
    }
}
