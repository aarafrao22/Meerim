package com.aarafrao.budgetmanagermeerim.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aarafrao.budgetmanagermeerim.adapters.ArticleAdapter;
import com.aarafrao.budgetmanagermeerim.models.IncomeModel;

import java.util.ArrayList;

public class ArticleListActivity extends AppCompatActivity {
    com.aarafrao.budgetmanagermeerim.databinding.ActivityArticleListBinding binding;
    ArrayList<IncomeModel> models = new ArrayList<>();
    ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.aarafrao.budgetmanagermeerim.databinding.ActivityArticleListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        models.add(new IncomeModel("Article1", "12/14/2022", 9));
        models.add(new IncomeModel("Article1", "12/14/2022", 9));
        models.add(new IncomeModel("Article1", "12/14/2022", 9));
        models.add(new IncomeModel("Article1", "12/14/2022", 9));
        models.add(new IncomeModel("Article1", "12/14/2022", 9));
        models.add(new IncomeModel("Article1", "12/14/2022", 9));
        models.add(new IncomeModel("Article1", "12/14/2022", 9));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArticleAdapter(models, this);
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}