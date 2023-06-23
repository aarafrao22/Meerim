package com.aarafrao.budgetmanagermeerim.database_expense;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.aarafrao.budgetmanagermeerim.models.IncomeModel;

import java.util.List;

@Dao
public interface ExpenseDAO {
    @Query("select * FROM expense")
    List<IncomeModel> getAllExpense();

    @Insert
    void addExpense(IncomeModel model);

    @Delete
    void deleteExpense(IncomeModel model);

}
