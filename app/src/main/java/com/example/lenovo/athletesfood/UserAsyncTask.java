package com.example.lenovo.athletesfood;

import android.os.AsyncTask;
import android.util.Log;

import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.DataBase;
import com.example.lenovo.athletesfood.models.dataBase.user.User;
import com.example.lenovo.athletesfood.models.dataBase.user.UserDao;

public class UserAsyncTask extends AsyncTask<User, Void, User> {
    private int TASK_KEY;
    private DataBase dataBase;

    public UserAsyncTask(int TASK_KEY) {
        this.TASK_KEY = TASK_KEY;
    }
    private User user;

    @Override
    protected User doInBackground(User... users) {

        dataBase = AthletesFoodApp.getInstance().getDataBase();
        UserDao userDao = dataBase.userDao();

        switch (TASK_KEY) {
            case Constants.TASK_INSERT:
                userDao.insertUser(users[0]);
                break;
        }
        return null;
    }
}
