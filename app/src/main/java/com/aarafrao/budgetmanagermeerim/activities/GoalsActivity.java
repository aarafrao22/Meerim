package com.aarafrao.budgetmanagermeerim.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aarafrao.budgetmanagermeerim.adapters.GoalsAdapter;
import com.aarafrao.budgetmanagermeerim.database.DatabaseHelper;
import com.aarafrao.budgetmanagermeerim.database_expense.ExpDatabaseHelper;
import com.aarafrao.budgetmanagermeerim.databinding.ActivityGoalsBinding;
import com.aarafrao.budgetmanagermeerim.goals_db.GoalsDBHelper;
import com.aarafrao.budgetmanagermeerim.models.ExpenseModel;
import com.aarafrao.budgetmanagermeerim.models.GoalsModel;
import com.aarafrao.budgetmanagermeerim.models.IncomeModel;

import java.util.ArrayList;
import java.util.List;

public class GoalsActivity extends AppCompatActivity {
    ActivityGoalsBinding binding;
    ArrayList<GoalsModel> models = new ArrayList();
    GoalsAdapter adapter;
    int incomeD = 0;
    int expensesD = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoalsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GoalsDBHelper goalsDBHelper = GoalsDBHelper.getExpense(getApplicationContext());
        DatabaseHelper income = DatabaseHelper.getDB(getApplicationContext());
        ExpDatabaseHelper expense = ExpDatabaseHelper.getExpense(getApplicationContext());

        List<IncomeModel> incomeList = income.notificationDAO().getAllIncome();
        List<ExpenseModel> expenseList = expense.expenseDAO().getAllExpense();

        for (int i = 0; i < incomeList.size(); i++) {
            incomeD += incomeList.get(i).getAmount();
        }
        for (int i = 0; i < expenseList.size(); i++) {
            expensesD += expenseList.get(i).getAmount();
        }

        binding.txtAmount.setText("$ "+String.valueOf(incomeD-expensesD));

        binding.btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, ActivityAdd.class).putExtra("ctx", "goals"));
        });

        models = new ArrayList<>(goalsDBHelper.expenseDAO().getAllGoals());
        for (int i = 0; i < models.size(); i++) {
            Log.d("TAG", "budgetList: " + models.get(i));
        }
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GoalsAdapter(models, this);
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}