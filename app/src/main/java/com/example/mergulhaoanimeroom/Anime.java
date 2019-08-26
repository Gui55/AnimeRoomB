package com.example.mergulhaoanimeroom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Anime implements Serializable {

    public Anime(String nome, String genero, int ano){
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
    }

    //VARIÁVEIS

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome, genero;
    private int ano;

    //GETTERS E SETTERS (O id só tem um getter)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
