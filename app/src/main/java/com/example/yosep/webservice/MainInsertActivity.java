package com.example.yosep.webservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainInsertActivity extends AppCompatActivity {

    EditText marca, descripcion, precio;
    String marcaStr, descripcionStr, precioStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insert);

        marca = findViewById(R.id.marcaTx);
        descripcion = findViewById(R.id.descripcionTx);
        precio = findViewById(R.id.precioTx);


    }

    public void insert(View view){

        marcaStr = marca.getText().toString();
        descripcionStr = descripcion.getText().toString();
        precioStr = precio.getText().toString();

        String method = "register";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,marcaStr,descripcionStr,precioStr);
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
