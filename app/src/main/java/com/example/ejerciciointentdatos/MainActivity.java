package com.example.ejerciciointentdatos;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3,et4 ;

    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et_nombre);
        et2 = (EditText)findViewById(R.id.et_telefono);
        et3 = (EditText)findViewById(R.id.et_email);
        et4 = (EditText)findViewById(R.id.et_descripcionDos);
        mDisplayDate = (TextView)findViewById(R.id.tv_fecha_nacimiento);


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;

                Log.d(TAG, "onDateSet: yyy/mm/dd"  + year + "/" + month + "/" + day);

                String  date =  day + "/" + month + "/" + year;
                mDisplayDate.setText(date);

            }
        };

    }

    public void enviar (View view){
        Intent i = new Intent(this, DetalleContacto.class);
        i.putExtra("nombre", et1.getText().toString());
        i.putExtra("telefono", et2.getText().toString());
        i.putExtra("email", et3.getText().toString());
        i.putExtra("descripcion", et4.getText().toString());
        i.putExtra("dateNacimiento", mDisplayDate.getText().toString());


        startActivity(i);
    }

    public void fecha (View view){
        Toast.makeText(this, "Tu fecha a sido guardada", Toast.LENGTH_SHORT).show();

    }
    public void limpiar (View view){

        mDisplayDate.setText("");
    }
}