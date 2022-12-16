package com.example.myapplication;

import android.app.Application;


import androidx.room.Room;

import com.example.myapplication.room.AppDatabase;

public class AppAplication extends Application

       public static AppDatabase db;

        @Override
        public void oncreate( ) {
            super void onCreate ();
            db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "mahasiswa").allowMainThreadQueries().build() ();

        }
}
