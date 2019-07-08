package com.venancio.testcystera.dao;


import android.os.AsyncTask;

import android.util.Log;
import androidx.annotation.NonNull;
import com.venancio.testcystera.database.AppDatabase;
import com.venancio.testcystera.entity.User;

import java.util.List;


public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db, User users) {
        PopulateDbAsync task = new PopulateDbAsync(db,users);
        task.execute();
    }

    private static User addUser(final AppDatabase db, User user) {
        db.userDao().insertAll(user);
        return user;
    }
    public static User getdata(@NonNull final AppDatabase db,@NonNull final String correo) {
        User userList = db.userDao().findbyusr(correo);
        return userList;
    }
    private static void populateWithTestData(AppDatabase db, User user) {

        addUser(db, user);
        User userList = db.userDao().findByName(user.getEmail(),user.getPassword());
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.getUid());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;
        private User us;

        PopulateDbAsync(AppDatabase db, User users) {
            mDb = db;
            us=users;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb,us);
            return null;
        }

    }
}
