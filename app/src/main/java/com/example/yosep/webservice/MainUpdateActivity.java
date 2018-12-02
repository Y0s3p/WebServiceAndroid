package com.example.yosep.webservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainUpdateActivity extends AppCompatActivity {

    EditText marca, descripcion, precio,oldmarca;
    String marcaStr, descripcionStr, precioStr,oldmarcaStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update);

        marca = findViewById(R.id.marcaTx);
        descripcion = findViewById(R.id.descripcionTx);
        precio = findViewById(R.id.precioTx);
        oldmarca = findViewById(R.id.oldmarcaTx);

    }

    public void update(View view){

        marcaStr = marca.getText().toString();
        descripcionStr = descripcion.getText().toString();
        precioStr = precio.getText().toString();
        oldmarcaStr = oldmarca.getText().toString();

        String method = "update";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,marcaStr,descripcionStr,precioStr,oldmarcaStr);
        finish();


    }

    public void volver(View view){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void VerInfo(View view){

        Intent intent = new Intent(this,MainListActivity.class);
        startActivity(intent);

    }

}
