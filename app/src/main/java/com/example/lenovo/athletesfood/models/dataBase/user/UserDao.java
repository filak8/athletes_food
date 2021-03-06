package com.example.lenovo.athletesfood.models.dataBase.user;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.lenovo.athletesfood.models.constant.Constants;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_USER_PARAMS)
    User getAll();
}
