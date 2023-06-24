package com.aarafrao.budgetmanagermeerim.database_budget;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.aarafrao.budgetmanagermeerim.database.BudgetDAO;
import com.aarafrao.budgetmanagermeerim.models.BudgetModel;

@Database(entities = BudgetModel.class, exportSchema = false, version = 1)
public abstract class BudgetDBHelper extends RoomDatabase {
    private static final String DB_NAME = "budget";
    private static com.aarafrao.budgetmanagermeerim.database_budget.BudgetDBHelper instance;

    public static synchronized com.aarafrao.budgetmanagermeerim.database_budget.BudgetDBHelper getBudget(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, com.aarafrao.budgetmanagermeerim.database_budget.BudgetDBHelper.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract BudgetDAO budgetDAO();
}