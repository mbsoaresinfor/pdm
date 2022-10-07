package com.example.myapplication;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// para visualizar as tabelas, usar a ferramenta no android studio, chamada
// AAPP INSPECTION

public class BancoDadosFruta extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "fruta";
    private static int VERSAO = 3;

    public BancoDadosFruta(Context context){
        super(context,NOME_BANCO,null,VERSAO);
        String name = getDatabaseName();
        Log.i("frutas",name);

        getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("fruta","Sendo executado onCreate");

        String sql = "CREATE TABLE fruta (" +
                "id INTEGER PRIMARY KEY," +
                "nome TEXT NOT NULL," +
                "preco REAL NOT NULL)";

        sqLiteDatabase.execSQL(sql);

        Log.i("fruta","Executado onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("fruta","Executado onUpgrade");
    }
}
