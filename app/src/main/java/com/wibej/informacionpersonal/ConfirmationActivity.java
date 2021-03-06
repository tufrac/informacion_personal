package com.wibej.informacionpersonal;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        Bundle data = getIntent().getExtras();
        String nombre = data.getString(getResources().getString(R.string.info_name));
        String fechaNacimientoDay = data.getString(getResources().getString(R.string.info_fecha_nacimiento_day));
        String fechaNacimientoMonth = data.getString(getResources().getString(R.string.info_fecha_nacimiento_month));
        String fechaNacimientoYear = data.getString(getResources().getString(R.string.info_fecha_nacimiento_year));
        String telefono = data.getString(getResources().getString(R.string.info_telefono));
        String email = data.getString(getResources().getString(R.string.info_email));
        String descripcion = data.getString(getResources().getString(R.string.info_descripcion));


        TextView tvNombre = (TextView) findViewById(R.id.tvName);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvInfoFechaNacimiento);
        TextView tvTelefono = (TextView) findViewById(R.id.tvInfoTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvInfoEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvInfoDescripcion);

        tvNombre.setText(nombre);
        tvFechaNacimiento.setText(
                new StringBuilder()
                        .append(fechaNacimientoDay).append("-")
                        .append(Integer.parseInt(fechaNacimientoMonth) + 1).append("-")
                        .append(fechaNacimientoYear));

        tvEmail.setText(email);
        tvTelefono.setText(telefono);
        tvDescripcion.setText(descripcion);
    }

    public void backEdit(View v){
        Intent back = new Intent(this, MainActivity.class);

        Bundle data = getIntent().getExtras();
        System.out.println(data);
        String nombre = data.getString(getResources().getString(R.string.info_name));
        String fechaNacimientoDay = data.getString(getResources().getString(R.string.info_fecha_nacimiento_day));
        String fechaNacimientoMonth = data.getString(getResources().getString(R.string.info_fecha_nacimiento_month));
        String fechaNacimientoYear = data.getString(getResources().getString(R.string.info_fecha_nacimiento_year));
        String telefono = data.getString(getResources().getString(R.string.info_telefono));
        String email = data.getString(getResources().getString(R.string.info_email));
        String descripcion = data.getString(getResources().getString(R.string.info_descripcion));

        back.putExtra(getResources().getString(R.string.info_name), nombre);
        back.putExtra(getResources().getString(R.string.info_fecha_nacimiento_day), fechaNacimientoDay);
        back.putExtra(getResources().getString(R.string.info_fecha_nacimiento_month), fechaNacimientoMonth);
        back.putExtra(getResources().getString(R.string.info_fecha_nacimiento_year), fechaNacimientoYear);
        back.putExtra(getResources().getString(R.string.info_telefono), telefono);
        back.putExtra(getResources().getString(R.string.info_email), email);
        back.putExtra(getResources().getString(R.string.info_descripcion), descripcion);

        startActivity(back);
    }
}
