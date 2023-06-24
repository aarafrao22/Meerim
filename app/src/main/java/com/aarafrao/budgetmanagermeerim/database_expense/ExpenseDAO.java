package com.aarafrao.budgetmanagermeerim.database_expense;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.aarafrao.budgetmanagermeerim.models.ExpenseModel;

import java.util.List;

@Dao
public interface ExpenseDAO {
    @Query("select * FROM expense")
    List<ExpenseModel> getAllExpense();

    @Insert
    void addExpense(ExpenseModel model);

    @Delete
    void deleteExpense(ExpenseModel model);

}
