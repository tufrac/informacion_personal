package com.wibej.informacionpersonal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle data = getIntent().getExtras();
        if(data != null){
            String personName = data.getString(getResources().getString(R.string.info_name));
            String fechaNacimiento = data.getString(getResources().getString(R.string.info_fecha_nacimiento));
            String telefono = data.getString(getResources().getString(R.string.info_telefono));
            String email = data.getString(getResources().getString(R.string.info_email));
            String descripcion = data.getString(getResources().getString(R.string.info_descripcion));

            EditText etPersonName = (EditText) findViewById(R.id.etNombreCompleto);
            DatePicker etFechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);
            EditText etTelefono = (EditText) findViewById(R.id.etTelefono);
            EditText etEmail = (EditText) findViewById(R.id.etEmail);
            EditText etDescripcion = (EditText) findViewById(R.id.etDescripcion );

            etPersonName.setText(personName);

            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
        }
    }

    public void loadConfirmation(View v){
        Intent siguiente = new Intent(this, ConfirmationActivity.class);
        EditText personName = (EditText) findViewById(R.id.etNombreCompleto);
        DatePicker fechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);
        EditText telefono = (EditText) findViewById(R.id.etTelefono);
        EditText email = (EditText) findViewById(R.id.etEmail);
        EditText descripcion = (EditText) findViewById(R.id.etDescripcion );
        int currentDate[] = new int[3];
        currentDate[0] = fechaNacimiento.getDayOfMonth();
        currentDate[1] = fechaNacimiento.getMonth();
        currentDate[2] = fechaNacimiento.getYear();


        siguiente.putExtra(getResources().getString(R.string.info_name), personName.getText().toString());
        siguiente.putExtra(getResources().getString(R.string.info_fecha_nacimiento), currentDate);
        siguiente.putExtra(getResources().getString(R.string.info_telefono), telefono.getText().toString());
        siguiente.putExtra(getResources().getString(R.string.info_email), email.getText().toString());
        siguiente.putExtra(getResources().getString(R.string.info_descripcion), descripcion.getText().toString());
        startActivity(siguiente);
    }
}
