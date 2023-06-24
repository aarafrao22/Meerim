package com.aarafrao.budgetmanagermeerim;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aarafrao.budgetmanagermeerim.adapters.ExpenseAdapter;
import com.aarafrao.budgetmanagermeerim.database_expense.ExpDatabaseHelper;
import com.aarafrao.budgetmanagermeerim.databinding.ActivityExpenseBinding;
import com.aarafrao.budgetmanagermeerim.models.ExpenseModel;

import java.util.ArrayList;

public class ExpenseActivity extends AppCompatActivity {
    ArrayList<ExpenseModel> models = new ArrayList<>();
    ExpDatabaseHelper databaseHelper;
    ExpenseAdapter adapter;
    ActivityExpenseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, ActivityAdd.class).putExtra("ctx", "expense"));
        });

        databaseHelper = ExpDatabaseHelper.getExpense(getApplicationContext());
        models = new ArrayList<>(databaseHelper.expenseDAO().getAllExpense());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExpenseAdapter(models, this);
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}