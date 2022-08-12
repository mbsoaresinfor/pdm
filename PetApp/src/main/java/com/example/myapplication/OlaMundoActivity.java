package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OlaMundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ola_mundo);
    }


    public void abreJanela(View view) {

        Bundle bundle = new Bundle();
        bundle.putString("meu_nome","marcelo soares");

        Intent intent= new Intent(this,SegundaActivity.class);
        intent.putExtras(intent);
        startActivity(intent);
    }
}