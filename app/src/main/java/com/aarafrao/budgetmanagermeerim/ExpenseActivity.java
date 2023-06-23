package com.aarafrao.budgetmanagermeerim;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aarafrao.budgetmanagermeerim.adapters.IncomeAdapter;
import com.aarafrao.budgetmanagermeerim.database_expense.ExpDatabaseHelper;
import com.aarafrao.budgetmanagermeerim.databinding.ActivityExpenseBinding;
import com.aarafrao.budgetmanagermeerim.models.IncomeModel;

import java.util.ArrayList;

public class ExpenseActivity extends AppCompatActivity {
    ArrayList<IncomeModel> models = new ArrayList<>();
    ExpDatabaseHelper databaseHelper;
    IncomeAdapter adapter;
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
        models = new ArrayList<>(databaseHelper.expenseDAO().getAllAppointments());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new IncomeAdapter(models, this);
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}