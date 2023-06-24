package com.aarafrao.budgetmanagermeerim.goals_db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.aarafrao.budgetmanagermeerim.models.GoalsModel;

import java.util.List;

@Dao
public interface GoalsDAO {
    @Query("SELECT * FROM goals")
    List<GoalsModel> getAllGoals();

    @Insert
    void addGoals(GoalsModel model);

    @Delete
    void deleteGoals(GoalsModel model);
}
