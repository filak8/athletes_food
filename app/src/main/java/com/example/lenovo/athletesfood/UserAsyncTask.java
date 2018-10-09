package com.example.lenovo.athletesfood;

import android.os.AsyncTask;
import android.util.Log;

import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.DataBase;
import com.example.lenovo.athletesfood.models.dataBase.User.User;
import com.example.lenovo.athletesfood.models.dataBase.User.UserDao;

public class UserAsyncTask extends AsyncTask<User, Void, Void> {
    private int TASK_KEY;
    private User user;
    private DataBase dataBase;

    public UserAsyncTask(int TASK_KEY) {
        this.TASK_KEY = TASK_KEY;
    }

    @Override
    protected Void doInBackground(User... users) {

        dataBase = AthletesFoodApp.getInstance().getDataBase();
        UserDao userDao = dataBase.userDao();

        switch (TASK_KEY) {
            case Constants.TASK_INSERT:
                userDao.insertUser(users[0]);
                Log.d("AAA", "Room User: " + userDao.getAll().toString());
                break;
            case Constants.TASK_DELETE:
                break;
        }

        return null;
    }
}
