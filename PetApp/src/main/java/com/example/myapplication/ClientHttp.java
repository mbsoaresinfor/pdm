package com.example.myapplication;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ClientHttp extends AsyncTask<String, Void, String> {

    private String sendHTTPData(String URL,String metodo,String corpo) throws MalformedURLException {
        URL url = new URL(URL);
        int codigoResposta;
        HttpURLConnection conexao = null;
        InputStream is = null;
        String retornoString = "";
        try {

            conexao = (HttpURLConnection) url.openConnection();
            conexao.setDoInput(true);
            conexao.setRequestMethod(metodo);
            conexao.setRequestProperty("Content-Type", "application/json; utf-8");
            if("POST".equals(metodo) || "PUT".equals(metodo)) {
                conexao.setRequestProperty("Accept", "text/plain");
            }else{
                conexao.setRequestProperty("Accept", "application/json");
            }
            conexao.connect();

            if("POST".equals(metodo) || "PUT".equals(metodo)) {
                OutputStream outStream = conexao.getOutputStream();
                byte[] input = corpo.getBytes("utf-8");
                outStream.write(input,0,input.length);
                outStream.close();
            }

            codigoResposta = conexao.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                is = conexao.getInputStream();
            } else {
                is = conexao.getErrorStream();
            }
            retornoString = converterInputStreamToString(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ;
            conexao.disconnect();
        }

        return retornoString;
    }



    private String converterInputStreamToString(InputStream is) throws Exception {
        StringBuffer buffer = new StringBuffer();

        BufferedReader br = null;
        String linha;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((linha = br.readLine()) != null) {
                buffer.append(linha);
            }
        } finally {
            br.close();
        }

        return buffer.toString();
    }

    @Override
    protected String doInBackground(String... params) {
        String ret = "";

        try {
            String url = params[0];
            String metodo = params[1];
            String corpo = params[2];
            ret =  sendHTTPData(url,metodo,corpo);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ret;

    }

}