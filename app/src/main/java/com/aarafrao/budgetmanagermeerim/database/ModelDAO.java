package com.aarafrao.budgetmanagermeerim.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.aarafrao.budgetmanagermeerim.models.IncomeModel;

import java.util.List;

@Dao
public interface ModelDAO {
    @Query("select * FROM notifications")
    List<IncomeModel> getAllAppointments();

    @Insert
    void addAppointment(IncomeModel model);

    @Delete
    void deleteNotification(IncomeModel model);

}
