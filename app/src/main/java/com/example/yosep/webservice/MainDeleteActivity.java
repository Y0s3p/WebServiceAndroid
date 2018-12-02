package com.example.yosep.webservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainDeleteActivity extends AppCompatActivity {

    EditText marca;
    String marcaStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_delete);

        marca = findViewById(R.id.marcaTx);

    }

    public void delete(View view){

        marcaStr = marca.getText().toString();

        String method = "delete";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,marcaStr);
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
