package com.example.myapplication.Activity;

import static com.example.myapplication.AppAplication.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.room.Mahasiswa;

public class AddUserActivity extends AppCompatActivity {

    private Button insertData;
    private EditText etAlamat;
    private EditText etKejuruan;
    private EditText etNama;
    private EditText etNim;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        insertData = findViewById(R.id.btInsert);
        etAlamat = findViewById(R.id.etAlamat);
        etKejuruan = findViewById(R.id.etKejuruan);
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);

        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if
                ( !etAlamat.getText().toString().isEmpty()&&!etKejuruan.getText().toString().isEmpty()&&
                 !etNama.getText().toString().isEmpty()&&!etNim.getText().toString().isEmpty()) {


                    mahasiswa = new Mahasiswa();
                    mahasiswa.setAlamat(etAlamat.getText().toString());
                    mahasiswa.setKejuruan(etKejuruan.getText().toString());
                    mahasiswa.setNama(etNama.getText().toString());
                    mahasiswa.setNim(etNim.getText().toString());
                    db.userDap().insertAll(mahasiswa);
                    startActivity(new Intent(AddUserActivity.this, UserActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(), "Mohon masukan dengan benar",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

}