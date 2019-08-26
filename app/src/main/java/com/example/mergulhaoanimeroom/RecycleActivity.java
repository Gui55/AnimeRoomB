package com.example.mergulhaoanimeroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {

    private RecyclerView recyclerView; //O RecyclerView
    private RecyclerView.LayoutManager recycleLayoutManager; //O LayoutManager do RecyclerView
    AnimeAdapter animeAdapter; //O adapatador de Animes do RecyclerView

    private FloatingActionButton floatingActionButton; //O floating action button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        configurarRecyclerView();
    }

    private void configurarRecyclerView() {

        //Instância da RecyclerView e seu LayoutManager
        recyclerView=(RecyclerView)findViewById(R.id.recycle);

        recycleLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recycleLayoutManager);

        //Definindo o adapatador de Animes para o RecyclerView
        animeAdapter = new AnimeAdapter(this, MainActivity.animeDao.getAnimes());
        recyclerView.setAdapter(animeAdapter);
    }
}
