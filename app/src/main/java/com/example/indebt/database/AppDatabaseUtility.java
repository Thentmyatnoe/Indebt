package com.example.indebt.database;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseUtility {
    public static AppDatabase getAppDatabase(Context context){
        AppDatabase appDatabase= Room.databaseBuilder(context,AppDatabase.class,"db-debt")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        return appDatabase;
    }
}
