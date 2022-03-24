package com.anton.formregistrasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText nama, email, password;
    RadioButton jenisKelamin;
    RadioGroup gender;
    SeekBar seekBarUmur;
    TextView seekBarValue,spinnerValue;
    ToggleButton toggleAsrama;
    Spinner prodi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //text input
        nama    = (EditText) findViewById(R.id.nama)
        email   = (EditText) findViewById(R.id.email)
        password = (EditText) findViewById(R.id.password)

        //radio Button
        gender = (RadioGroup) findViewById(jenisKelamin)

        //seekbar
        seekBarUmur=(SeekBar) findViewById(R.id.umur);
        seekBarValue=(TextView) findViewById(R.id.viewUmur);

        seekBarUmur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                seekBarValue.setText(String.valueOf(progress +"Tahun"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Toggle Asrama
        toggleAsrama=(ToggleButton) findViewById(R.id.toggleAsrama);

        //Spinner
        prodi = (spinnerValue)findViewById(R.id.prodi);
        spinnerValue = (TextView) findViewById(R.id.viewProdi);
        ArrayAdapter <CharSequence> adapter= ArrayAdapter.createFromResource(Context this
                R.array.daftraProdi, android.R.layout.simple_spinner_dropdown_item);
        prodi.setAdapter(adapter);
        prodi.setOnItemSelectedListener(this);


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String prodisaya = adapterView.getItemAtPosition(i).toString();
        spinnerValue.setText(String.valueOf(prodisaya));


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void submitRegis(View view) {
       int RadioId = gender.getCheckedRadioButtonId();
       jenisKelamin = (RadioButton) findViewById(RadioId);

       Intent hubung = new Intent( this, HasilActivity.class);
       hubung.putExtra("nama", nama.getText().toString());
       hubung.putExtra("email", email.getText().toString());
       hubung.putExtra("password", password.getText().toString());
       hubung.putExtra("jenisKelamin", jenisKelamin.getText().toString());
       hubung.putExtra("age", seekBarValue.getText().toString());
       hubung.putExtra("prodi", spinnerValue.getText().toString());
       hubung.putExtra("asrama", toggleAsrama.getText().toString());
       startActivity(hubung);
    }
}