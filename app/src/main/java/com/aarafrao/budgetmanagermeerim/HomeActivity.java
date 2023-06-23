package com.aarafrao.budgetmanagermeerim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.aarafrao.budgetmanagermeerim.database.DatabaseHelper;
import com.aarafrao.budgetmanagermeerim.databinding.ActivityHomeBinding;
import com.aarafrao.budgetmanagermeerim.models.IncomeModel;

import java.text.ParseException;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityHomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        initClickListener();

    }

    private void initClickListener() {
        binding.cardIncome.setOnClickListener(this);
        binding.cardExp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.card_exp)
            startActivity(new Intent(HomeActivity.this, ExpenseActivity.class));
        else if (view.getId() == R.id.card_income)
            startActivity(new Intent(HomeActivity.this, IncomeActivity.class));
//        else if (view.getId() == R.id.card_exp)
//            startActivity(new Intent(HomeActivity.this, ExpenseActivity.class));
//        else if (view.getId() == R.id.card_exp)
//            startActivity(new Intent(HomeActivity.this, ExpenseActivity.class));
//        else if (view.getId() == R.id.card_exp)
//            startActivity(new Intent(HomeActivity.this, ExpenseActivity.class));

    }
}