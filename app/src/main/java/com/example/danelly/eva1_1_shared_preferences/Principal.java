package com.example.danelly.eva1_1_shared_preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Principal extends AppCompatActivity {
    EditText txtNom, txtApe, txtEdad;
    SharedPreferences shPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //vinculamos editText al codigo
        setContentView(R.layout.activity_principal);
        txtNom = (EditText) findViewById(R.id.txtNom);
        txtApe = (EditText) findViewById(R.id.txtApe);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        //leer datos
        shPref = getSharedPreferences("datos", Activity.MODE_PRIVATE);
        String sNom, sApe;
        int iEdad;
        sNom = shPref.getString("NOMBRE", "Danelly");
        sApe = shPref.getString("APELLIDO", "Montañez");
        iEdad = shPref.getInt("EDAD", 21);
        txtNom.setText(sNom);
        txtApe.setText(sApe);
        txtEdad.setText("" + iEdad);
        //La ventana será del color indicado
        getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
    }
        @Override
        protected void onPause() {
            super.onPause();
            //guardamos los datos
            String sNom, sApe;
            int iEdad;
            sNom = txtNom.getText().toString();
            sApe = txtApe.getText().toString();
            iEdad = Integer.parseInt(txtEdad.getText().toString());

            SharedPreferences.Editor edtDatos = shPref.edit();
            edtDatos.putString("NOMBRE", sNom);
            edtDatos.putString("APELLIDO", sApe);
            edtDatos.putInt("EDAD", iEdad);

            edtDatos.commit();
        }
}
