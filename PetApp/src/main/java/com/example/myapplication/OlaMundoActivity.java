package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class OlaMundoActivity extends AppCompatActivity {

    List<Fruta> listafruta = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ola_mundo);
    }

    public void salvar(View view){
        // pegar os dados da tela.
        // fazer a validacao.
        Fruta fruta = new Fruta();
//        fruta.nome = "maca";
//        fruta.preco = 5f;
        listafruta.add(fruta);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) listafruta);

        Intent intent= new Intent(this,SegundaActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);



    }


    public void abreJanela(View view) {

        EditText textView = findViewById(R.id.editTextTextPersonName);
        String textoDigitado = textView.getText().toString();

        // && and
        // || or
        // ! not
        if(textoDigitado.equals("brasil")){
            Bundle bundle = new Bundle();
            bundle.putString("meu_nome","marcelo soares");
            bundle.putSerializable("lista" , null);

            Intent intent= new Intent(this,SegundaActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            Toast.makeText(this,"valor invalido",Toast.LENGTH_LONG).show();
        }


    }
}