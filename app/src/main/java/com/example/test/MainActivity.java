package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recy;
    adapterCl adapterCl;
    public List<info> inf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy = findViewById(R.id.recy);
        inf = new ArrayList<>();
        String txt = "UMSM Div";
        String tx2="University Mustafa Stmboli Mascara";
        info in = new info();
        for(int i=0;i<5;i++){

            in.setTitel1(txt+" i");
            in.setTitel2(tx2+" i");

            inf.add(in);
        }


        adapterCl = new adapterCl(this,inf);
        recy.setAdapter(adapterCl);
        recy.setLayoutManager(new LinearLayoutManager(this));
    }
}