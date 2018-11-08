package com.example.lenovo.athletesfood;

import android.os.AsyncTask;

import com.example.lenovo.athletesfood.models.dataBase.DataBase;
import com.example.lenovo.athletesfood.models.dataBase.user.User;
import com.example.lenovo.athletesfood.models.dataBase.user.UserDao;

public class EnergyPoolCalculator {
    private static final int BASE_POOL = 655;
    private static final float COEFF_GROWTH = 1.8f;
    private static final float COEFF_WEIGHT = 9.6f;
    private static final float COEFF_AGE = 4.7f;

    private int mGrowth;
    private double mWeight;
    private int mAge;
    private double mPhysicalActivity;
    private int energyPool;
    private User mUser;
    private UserAsyncTask userAsyncTask;

    private OnAsyncTaskFinishedListener onAsyncTaskFinishedListener;

    public EnergyPoolCalculator(OnAsyncTaskFinishedListener onAsyncTaskFinishedListener) {
        this.onAsyncTaskFinishedListener = onAsyncTaskFinishedListener;
        userAsyncTask = new UserAsyncTask();
        userAsyncTask.execute();

    }

    class UserAsyncTask extends AsyncTask<Void, Void, User> {

        @Override
        protected User doInBackground(Void... voids) {
            DataBase dataBase = AthletesFoodApp.getInstance().getDataBase();
            UserDao userDao = dataBase.userDao();
            mUser = userDao.getAll();
            return mUser;
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            mGrowth = user.getGrowth();
            mWeight = user.getWeight();
            mAge = user.getAge();
            mPhysicalActivity = user.getCoeffOfMobility();
            energyPool = (int) ((BASE_POOL + (mGrowth * COEFF_GROWTH) + (mWeight * COEFF_WEIGHT) -
                    (mAge * COEFF_AGE)) * mPhysicalActivity);

            onAsyncTaskFinishedListener.onAsyncTaskFinished(energyPool);
        }
    }
}
