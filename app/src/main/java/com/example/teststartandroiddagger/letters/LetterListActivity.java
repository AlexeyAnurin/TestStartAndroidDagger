package com.example.teststartandroiddagger.letters;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

import com.example.teststartandroiddagger.App;
import com.example.teststartandroiddagger.datatype.Folder;
import com.example.teststartandroiddagger.datatype.Letter;
import com.example.teststartandroiddagger.R;

public class LetterListActivity extends AppCompatActivity {

    @Inject
    public LetterListActivityPresenter presenter;

    private ListView lettersListView;
    private ArrayAdapter<Letter> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters_list);
        Folder folder = (Folder) getIntent().getSerializableExtra("folder");
        App.getInstance().getMailComponent().createLetterListActivityComponent(new LetterListActivityModule(folder)).injectLettersListActivity(this);

        lettersListView = (ListView) findViewById(R.id.lettersList);

        adapter = new ArrayAdapter<Letter>(this, android.R.layout.simple_list_item_1);

        lettersListView.setAdapter(adapter);

        presenter.loadLetters();

    }

    @Inject
    void setActivity() {
        presenter.setActivity(this);
    }

    public void showLetters(List<Letter> letters) {
        adapter.clear();
        adapter.addAll(letters);
    }
}
