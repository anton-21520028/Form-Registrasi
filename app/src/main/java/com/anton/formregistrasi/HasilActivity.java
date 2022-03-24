package com.anton.formregistrasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3, txt4, txt5,txt6, txt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        txt1 =(TextView) findViewById(R.id.namaUser);
        txt2 =(TextView) findViewById(R.id.emailUser);
        txt3 =(TextView) findViewById(R.id.passwordUser);
        txt4 =(TextView) findViewById(R.id.genderUser);
        txt5 =(TextView) findViewById(R.id.ageUser);
        txt6 =(TextView) findViewById(R.id.prodi);
        txt7 =(TextView) findViewById(R.id.asramaUser);

        String nama=getIntent().getExtras().getString("name");
        String email=getIntent().getExtras().getString("email");
        String password=getIntent().getExtras().getString("password");
        String gender=getIntent().getExtras().getString("jeniskelamin");
        String age=getIntent().getExtras().getString("age");
        String prodi=getIntent().getExtras().getString("prodi");
        String asrama=getIntent().getExtras().getString("asrama");

       txt1.setText("Nama anda\n"+nama);
       txt2.setText("Email anda\n"+email);
       txt3.setText("Password anda\n"+password);
       txt4.setText("Jenis Kelamin anda\n"+gender);
       txt5.setText("Umur anda\n"+age);
       txt6.setText("Prodi anda\n"+prodi);
       txt7.setText("Asrama anda\n"+asrama);




    }
}