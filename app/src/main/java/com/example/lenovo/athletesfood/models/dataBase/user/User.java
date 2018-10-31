package com.example.lenovo.athletesfood.models.dataBase.user;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.lenovo.athletesfood.models.constant.Constants;

@Entity(tableName = Constants.ARGS_KEY_DATABASE_TABLE_NAME_USER_PARAMS)
public class User {
    @PrimaryKey
    private int id;
    private int growth;
    private float weight;
    private int age;
    private float coeffOfMobility;

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int mGrowth) {
        this.growth = mGrowth;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float mWeight) {
        this.weight = mWeight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int mAge) {
        this.age = mAge;
    }

    public float getCoeffOfMobility() {
        return coeffOfMobility;
    }

    public void setCoeffOfMobility(float mCoeffOfMobility) {
        this.coeffOfMobility = mCoeffOfMobility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
