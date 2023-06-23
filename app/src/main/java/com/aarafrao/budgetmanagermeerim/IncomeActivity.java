package com.aarafrao.budgetmanagermeerim;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aarafrao.budgetmanagermeerim.adapters.IncomeAdapter;
import com.aarafrao.budgetmanagermeerim.database.DatabaseHelper;
import com.aarafrao.budgetmanagermeerim.databinding.ActivityIncomeBinding;
import com.aarafrao.budgetmanagermeerim.models.IncomeModel;

import java.util.ArrayList;

public class IncomeActivity extends AppCompatActivity {
    ArrayList<IncomeModel> models = new ArrayList();
    DatabaseHelper databaseHelper;
    ActivityIncomeBinding binding;
    IncomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIncomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, ActivityAdd.class));
        });

        databaseHelper = DatabaseHelper.getDB(getApplicationContext());
        models = new ArrayList<>(databaseHelper.notificationDAO().getAllAppointments());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new IncomeAdapter(models, this);
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}