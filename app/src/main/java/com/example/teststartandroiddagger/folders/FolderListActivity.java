package com.example.teststartandroiddagger.folders;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

import com.example.teststartandroiddagger.App;
import com.example.teststartandroiddagger.datatype.Folder;
import com.example.teststartandroiddagger.letters.LetterListActivity;
import com.example.teststartandroiddagger.R;

public class FolderListActivity extends AppCompatActivity {

    @Inject
    public FolderListActivityPresenter presenter;

    private ListView foldersListView;
    private ArrayAdapter<Folder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folders_list);

        App.getInstance().getMailComponent().createFoldersListActivityComponent().injectFoldersListActivity(this);

        foldersListView = (ListView) findViewById(R.id.foldersList);

        adapter = new ArrayAdapter<Folder>(this, android.R.layout.simple_list_item_1);

        foldersListView.setAdapter(adapter);
        foldersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openFolder(adapter.getItem(i));
            }
        });

        presenter.loadFolders();

    }

    @Inject
    void setActivity() {
        presenter.setActivity(this);
    }

    void showFolders(List<Folder> folders) {
        adapter.clear();
        adapter.addAll(folders);
    }

    void openFolder(Folder folder) {
        Intent intent = new Intent(this, LetterListActivity.class);
        intent.putExtra("folder", folder);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().releaseMailComponent();
    }
}
