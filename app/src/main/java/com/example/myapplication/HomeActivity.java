package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.util.PreferencesHelper;

public class HomeActivity extends AppCompatActivity {
    private Button btnActivity, btnFragmen;
    private EditText adnama;
    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        preferencesHelper = PreferencesHelper.getINSTANCE(getApplicationContext());

        btnActivity = findViewById(R.id.btnActivity);
        btnFragmen = findViewById(R.id.btnFragmen);
        adnama = findViewById(R.id.adnama);

        btnActivity.setOnClickListener(view -> {
            preferencesHelper.setLogin(true);
            preferencesHelper.setNama(adnama.getText().toString());
            Intent homeIntent = new Intent(HomeActivity.this, FirstActivity.class);
          //  homeIntent.putExtra("nama", adnama.getText().toString())
            startActivity(homeIntent);
        });
        btnFragmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(HomeActivity.this, SeconActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}