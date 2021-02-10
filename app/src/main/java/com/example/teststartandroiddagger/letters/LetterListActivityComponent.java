package com.example.teststartandroiddagger.letters;

import dagger.Subcomponent;
import com.example.teststartandroiddagger.ActivityScope;

@ActivityScope
@Subcomponent(modules = LetterListActivityModule.class)
public interface LetterListActivityComponent {

    void injectLettersListActivity(LetterListActivity activity);

}
