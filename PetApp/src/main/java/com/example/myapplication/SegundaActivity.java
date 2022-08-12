package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        //String nome = (String)getIntent().getSerializableExtra("meu_nome");
        String nome = "marcelo soares";

        Toast.makeText(this,nome, Toast.LENGTH_LONG);
    }
}