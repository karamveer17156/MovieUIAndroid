package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.michaldrabik.tapbarmenulib.TapBarMenu;

import java.util.ArrayList;

public class screen_movie extends AppCompatActivity {
    TapBarMenu tapBarMenu;
    RecyclerView recyclerView;
    Adapter adapter;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_movie);
        tapBarMenu = findViewById(R.id.tapBarMenu);
        recyclerView = findViewById(R.id.Recycler_view_mainScreen);
        items = new String[8];
        items[0] = new String("Munna Bai");
        items[1] = "Kamwali Bai";
        items[2] = "Rockstar";
        items[3] = ("Monster");
        items[4] = ("Pumpkin");
        items[5] = ("Hitler");
        items[6] = ("Corona");
        items[7] = ("End Game");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, items);
        recyclerView.setAdapter(adapter);
        tapBarMenu.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                tapBarMenu.toggle();
            }
        });

    }
}
