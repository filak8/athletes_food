package com.example.lenovo.athletesfood.models.dataBase.food.porridge;

import android.arch.persistence.room.Entity;

import com.example.lenovo.athletesfood.models.constant.Constants;

@Entity(tableName = Constants.ARGS_KEY_DATABASE_TABLE_NAME_PORRIDGE_DATABASE)
public class Porridge {
    private String namePorridge;

}
