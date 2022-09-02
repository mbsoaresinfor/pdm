package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ListagemFrutasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_frutas);
        List<Fruta> listaFruta = (List<Fruta>) getIntent().
                                        getSerializableExtra("lista");

        TextView textView = findViewById(R.id.textViewListagemFrutas);

        StringBuilder mensagem = new StringBuilder();
        for(int i=0; i < listaFruta.size(); i++){
            Fruta fruta = listaFruta.get(i);
            mensagem.append(fruta.getNome());
            mensagem.append(" R$ ");
            mensagem.append(fruta.getPreco());
            mensagem.append("\n");
            mensagem.append("---------------------------------");
            mensagem.append("\n");

        }

        textView.setText(mensagem.toString());




    }
}