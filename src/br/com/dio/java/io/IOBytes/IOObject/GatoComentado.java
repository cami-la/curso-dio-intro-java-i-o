package br.com.dio.java.io.IOBytes.IOObject;

import java.io.Serializable;

public class GatoComentado implements Serializable{

    public static final long serialVersionUID = 3L; //abributo que serealiza a classe
    private String nome;
    private String cor;
    private int idade;
    private boolean castrado;
    private transient boolean ronrona; //transiente aqui serve para deixar esse atributo "invisível" para serealização

    public GatoComentado() {}

    public GatoComentado(String nome, String cor, int idade, boolean castrado, boolean ronrona) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade;
        this.castrado = castrado;
        this.ronrona = ronrona;
    }

    public GatoComentado(String nome, String cor, int idade, boolean castrado) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade;
        this.castrado = castrado;
    }

    public GatoComentado(String nome, String cor, int idade) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public boolean isRonrona() {
        return ronrona;
    }
}
