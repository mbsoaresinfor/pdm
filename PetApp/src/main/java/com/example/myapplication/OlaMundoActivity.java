package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OlaMundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ola_mundo);
    }

    public void mostraMensagem(View view) {
        TextView textView = findViewById(R.id.textViewMensagem);
        textView.setText("Ola mundo...cliquei no botão :)");
    }
}