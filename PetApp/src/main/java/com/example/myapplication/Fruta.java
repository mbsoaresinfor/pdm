package com.example.myapplication;

import java.io.Serializable;

public class Fruta implements Serializable {

    private String nome;
    private Float preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
