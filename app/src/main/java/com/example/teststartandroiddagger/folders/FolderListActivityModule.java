package com.example.teststartandroiddagger.folders;


import dagger.Module;
import dagger.Provides;
import com.example.teststartandroiddagger.ActivityScope;
import com.example.teststartandroiddagger.mail.MailManager;

@Module
public class FolderListActivityModule {

    @ActivityScope
    @Provides
    public FolderListActivityPresenter provideFoldersListActivityPresenter(MailManager mailManager) {
        return new FolderListActivityPresenter(mailManager);
    }
}
