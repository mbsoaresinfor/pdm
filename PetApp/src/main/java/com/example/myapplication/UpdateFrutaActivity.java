package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class UpdateFrutaActivity extends AppCompatActivity {

    BancoDadosFruta bancoDadosFruta = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_fruta);

        bancoDadosFruta = new BancoDadosFruta(this);
    }

    public void atualizarFruta(View view) {

        EditText id = findViewById(R.id.editTextIdFruta);
        EditText novoPrecoFruta = findViewById(R.id.editTextNovoPrecoFruta);

        Integer idInteiro = Integer.parseInt(id.getText().toString());
        Float precoFrutaFloat = Float.parseFloat(novoPrecoFruta.getText().toString());


        bancoDadosFruta.updatePrecoFruta(idInteiro,precoFrutaFloat);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDadosFruta.buscaTodasFrutas());

        Intent intent= new Intent(this,ListagemFrutasActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}