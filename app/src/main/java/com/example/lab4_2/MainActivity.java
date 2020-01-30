package com.example.lab4_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import name.ank.lab4.BibDatabase;
import name.ank.lab4.BibEntry;

public class MainActivity extends AppCompatActivity {
    private BibDatabase database;

    protected void init() {
        try {
            database = new BibDatabase(new
                    InputStreamReader(getResources().openRawResource(R.raw.articles)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new BibLibAdapter(this, database);
        recyclerView.setAdapter(mAdapter);
    }
    private BibLibAdapter updateAdapter() {
        return new BibLibAdapter(this, database);
    }

}