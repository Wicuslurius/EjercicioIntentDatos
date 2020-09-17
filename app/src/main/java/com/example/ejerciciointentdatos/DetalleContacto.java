package com.example.ejerciciointentdatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tv1, tv2, tv3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        tv1 = (TextView)findViewById(R.id.tv_nombre);
        tv2 = (TextView)findViewById(R.id.tv_telefono);
        tv3 = (TextView)findViewById(R.id.tv_email);
        tv4 = (TextView)findViewById(R.id.tv_descripcion);
        tv5 = (TextView)findViewById(R.id.tv_fecha);

        String nombre = getIntent().getStringExtra("nombre");
        String telefono =getIntent().getStringExtra("telefono");
        String email = getIntent().getStringExtra("email");
        String descripcion = getIntent().getStringExtra("descripcion");
        String dateNacimiento = getIntent().getStringExtra("dateNacimiento");


        tv1.setText("Nombre : " + nombre);
        tv2.setText("Telefono : " + telefono);
        tv3.setText("Email : " + email);
        tv4.setText("Descripcion : " + descripcion);
        tv5.setText("Fecha : " + dateNacimiento);


    }

    //Metodo Editar Datos

    public void editar (View view){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}