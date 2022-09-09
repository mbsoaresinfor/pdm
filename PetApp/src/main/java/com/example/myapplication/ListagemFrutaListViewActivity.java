package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListagemFrutaListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_fruta_list_view);

        Fruta fruta1 = new Fruta();
        fruta1.setPreco(3f);
        fruta1.setNome("banana");

        Fruta fruta2 = new Fruta();
        fruta2.setPreco(5f);
        fruta2.setNome("maça");

        Fruta fruta3 = new Fruta();
        fruta3.setPreco(6f);
        fruta3.setNome("melao");

        Fruta fruta4 = new Fruta();
        fruta4.setPreco(5f);
        fruta4.setNome("uva");

        Fruta fruta5 = new Fruta();
        fruta5.setPreco(5f);
        fruta5.setNome("couve");

        List<Fruta> lista = new ArrayList<>();
        lista.add(fruta1);
        lista.add(fruta2);
        lista.add(fruta3);
        lista.add(fruta4);
        lista.add(fruta5);

        FrutaAdapter frutaAdapter = new FrutaAdapter(this,lista);
        ListView listview = findViewById(R.id.listViewFrutas);
        listview.setAdapter(frutaAdapter);


    }
}