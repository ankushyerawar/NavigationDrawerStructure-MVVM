package com.ankushyerwar.blankndstructure.data.local.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ankushyerwar.blankndstructure.data.local.database.entity.UserEntity;
import com.ankushyerwar.blankndstructure.utils.AppConstants;

@Database(entities = {UserEntity.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppConstants.DATABASE_NAME)
                        .build();
            }
        }
        return INSTANCE;
    }
}
