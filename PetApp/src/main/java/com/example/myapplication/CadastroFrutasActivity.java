package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CadastroFrutasActivity extends AppCompatActivity {


    BancoDadosFruta bancoDadosFruta = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_frutas);

        bancoDadosFruta = new BancoDadosFruta(this);

        String resultado = null;
        String enderecoServidor = "https://api-exemplo-marcelo.herokuapp.com/usuarios";

        try{
            resultado = new ClientHttp()
                    .executeOnExecutor(Executors.newSingleThreadExecutor(),
                            enderecoServidor,"GET","").get();
            Log.i("aula",resultado);
            Usuario[] usuarios = new Gson().fromJson(resultado,Usuario[].class);
            List<Usuario> listaUsuario = Arrays.asList(usuarios);
            for(Usuario usuario : listaUsuario){
                Log.i("aula",usuario.nome);
                Log.i("aula",usuario.senha);
                Log.i("aula",usuario.email);
            }

        }catch(Exception e){
            Log.e("aula",e.getMessage());
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("marcelo","executado onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("marcelo","executado onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("marcelo","executado onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("marcelo","executado onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("marcelo","executado onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("marcelo","executado onRestart");
    }

    public void salvar(View view) {
        EditText nome = findViewById(R.id.editTextTextNomeFruta);
        EditText preco = findViewById(R.id.editTextTextPrecoFruta);

        if(nome.getText().toString().equals("")){
            Toast.makeText(this,"ERROR, Nome está vazio",Toast.LENGTH_LONG).show();
            return;
        }
        if(nome.getText().toString().length() > 20){
            Toast.makeText(this,"ERROR, Nome tem mais de 20 caracteres",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if(preco.getText().toString().equals("")){
            Toast.makeText(this,"ERROR, Preço está vazio",Toast.LENGTH_LONG).show();
            return;
        }

        try{
            Double.parseDouble(preco.getText().toString());
        }catch(Exception e){
            Toast.makeText(this,"ERROR, Preço não é um número",
                    Toast.LENGTH_LONG).show();
            return;
        }

        Fruta fruta = new Fruta();
        fruta.setNome(nome.getText().toString());
        Float precoFloat = Float.parseFloat(preco.getText().toString());
        fruta.setPreco(precoFloat);

        //listaFruta.add(fruta);
        bancoDadosFruta.salvarFruta2(fruta);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDadosFruta.buscaTodasFrutas());

        Intent intent= new Intent(this,ListagemFrutasActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }

    public void abreTelaAtualizacao(View view) {

        Intent intent = new Intent(this,UpdateFrutaActivity.class);
        startActivity(intent);
    }
}