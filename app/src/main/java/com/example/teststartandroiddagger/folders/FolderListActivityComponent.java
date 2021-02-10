package com.example.teststartandroiddagger.folders;

import dagger.Subcomponent;
import com.example.teststartandroiddagger.ActivityScope;

@ActivityScope
@Subcomponent(modules = FolderListActivityModule.class)
public interface FolderListActivityComponent {

    void injectFoldersListActivity(FolderListActivity activity);

}
