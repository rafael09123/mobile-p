package com.example.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private static PreferencesHelper INSTANCE;
    private SharedPreferences sharedPreferences;

    private  PreferencesHelper (Context context){
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences( "com.example.myapplication", Context.MODE_PRIVATE)
    }
    public static PreferencesHelper getINSTANCE(Context context){
        if (INSTANCE == null){
            INSTANCE = new PreferencesHelper(context);
        }
        return INSTANCE

    }
    public SharedPreferences preferences (){
        return sharedPreferences;

    }
    public void setLogin (Boolean isLogin) {
        sharedPreferences.edit().putBoolean("isLogin", isLogin).apply();
    }
    public Boolean isLogin(){
        return  sharedPreferences.getBoolean( "isLogin", false);

    }
    public void setNama (String nama){
        sharedPreferences.edit().putString("nama", nama).apply();
    }
    public String getNama(){
        return sharedPreferences.getString("Nama","Jhon Doe")
    }
}
