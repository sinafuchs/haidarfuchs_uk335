package com.sixgroup.appsinaamin.persistence;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.sixgroup.appsinaamin.user.User;

@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    //creating a Database
    private static final String DB_NAME = "appDB";
    private static AppDatabase appDb;

    //if the Database is empty, fill it up with the tables
    public static AppDatabase getAppDb(Context context) {
        if (appDb == null) {
            appDb = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return appDb;
    }

    public abstract UserDao getUserDao();
}

