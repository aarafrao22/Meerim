package com.aarafrao.budgetmanagermeerim.database_expense;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.aarafrao.budgetmanagermeerim.database.BudgetDAO;
import com.aarafrao.budgetmanagermeerim.models.IncomeModel;

@Database(entities = IncomeModel.class, exportSchema = false, version = 1)
public abstract class ExpDatabaseHelper extends RoomDatabase {
    private static final String DB_NAME = "expense";
    private static com.aarafrao.budgetmanagermeerim.database_expense.ExpDatabaseHelper instance;

    public static synchronized com.aarafrao.budgetmanagermeerim.database_expense.ExpDatabaseHelper getExpense(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, com.aarafrao.budgetmanagermeerim.database_expense.ExpDatabaseHelper.class, DB_NAME)
                    .fallbackToDestructiveMigration().allowMainThreadQueries()
                    .build();

        }
        return instance;
    }

    public abstract BudgetDAO expenseDAO();
}