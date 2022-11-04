package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("email")
    public String email;
    @SerializedName("id")
    public Integer id;
    @SerializedName("nome")
    public String nome;
    @SerializedName("senha")
    public String senha;

}
