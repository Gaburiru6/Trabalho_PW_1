package com.example.trabalho_pw_1.Model;

public class Produto {
    private String ID;
    private String Preco;
    private String Nome;
    private String Descricao;
    private int Estoque;

    public Produto(int estoque, String descricao, String preco, String ID) {
        Estoque = estoque;
        Descricao = descricao;
        Preco = preco;
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPreco() {
        return Preco;
    }

    public void setPreco(String preco) {
        Preco = preco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getEstoque() {
        return Estoque;
    }

    public void setEstoque(int estoque) {
        Estoque = estoque;
    }
}
