package com.example.myapplication.Activity;

import static com.example.myapplication.AppAplication.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.room.AppDatabase;
import com.example.myapplication.room.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerviewUserAdapter recyclerAdapter;
    List<Mahasiswa> listMahasiswa = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView = findViewById(R.id.reycleView);
        fetchDataFromRoom();
        initReyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();
        listMahasiswa = db.userDap().getAll();

        for (int i = 0; i < listMahasiswa.size(); i++) {
            Log.e("Aplikasi", listMahasiswa.get(i).getAlamat() + i);
            Log.e("Aplikasi", listMahasiswa.get(i).getKejuruan() + i);
            Log.e("Aplikasi", listMahasiswa.get(i).getNama() + i);
            Log.e("Aplikasi", listMahasiswa.get(i).getNim() + i);
        }
        Log.e("cek list", "" + listMahasiswa.size());
    }
    private void initReyclerView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerAdapter = new RecyclerviewUserAdapter(this, listMahasiswa);

    }
       private void setAdapter( ){
        recyclerView.setAdapter(recyclerAdapter);
       }
    }