package com.aarafrao.budgetmanagermeerim.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.aarafrao.budgetmanagermeerim.R;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);


        String ctx = getIntent().getStringExtra("ctx");



    }
}