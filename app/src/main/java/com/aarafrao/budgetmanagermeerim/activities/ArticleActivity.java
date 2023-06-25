package com.aarafrao.budgetmanagermeerim.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.aarafrao.budgetmanagermeerim.databinding.ActivityArticleBinding;

public class ArticleActivity extends AppCompatActivity {

    ActivityArticleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityArticleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String ctx = getIntent().getStringExtra("ctx");


        //todo to be fetched from String.xml by R.strings.{your text}

        switch (ctx) {
            case "1":
                binding.txtTitleArticle.setText("Article 1");
                binding.txtBodyArticle.setText("Article Body");
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
        }


    }
}